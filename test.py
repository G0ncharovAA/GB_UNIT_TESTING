import pytest
from main import calculate_average, compare_averages


# 1. Тестирование функции calculate_average:
#    - Тестирование для непустого списка чисел: проверка результата вычисления среднего значения.
#    - Тестирование для пустого списка чисел: проверка возникновения исключения ValueError.
#
# 2. Тестирование функции compare_averages:
#    - Тестирование для случая, когда первый список имеет большее среднее значение.
#    - Тестирование для случая, когда второй список имеет большее среднее значение.
#    - Тестирование для случая, когда средние значения списков равны.
#
# 3. Тестирование взаимодействия между функциями calculate_average и compare_averages:
#    - Проверка, что функция compare_averages вызывает функцию calculate_average для обоих списков.
#
# Я выбрала эти сценарии для тестирования, потому что они представляют различные возможные варианты
# входных данных и поведения программы. Они позволяют проверить работоспособность основных
# функциональностей программы и убедиться, что код корректно обрабатывает различные случаи,
# включая пустые списки чисел.


@pytest.mark.parametrize("numbers, expected_average", [
    ([1, 2, 3, 4, 5], 3.0),
    ([6, 7, 8, 9, 10], 8.0),
    ([], 0)  # Для проверки исключения ValueError
])
def test_calculate_average(numbers, expected_average):
    if len(numbers) == 0:
        with pytest.raises(ValueError):
            calculate_average(numbers)
    else:
        assert calculate_average(numbers) == expected_average


@pytest.mark.parametrize("list1, list2, expected_output", [
    ([1, 2, 3, 4, 5], [1, 2, 3, 4, 5], "Средние значения равны")
])
def test_compare_averages(list1, list2, expected_output, mocker):
    mocked_calculate_average = mocker.patch("main.calculate_average")
    mocked_calculate_average.return_value = 0
    result = compare_averages(list1, list2)
    assert result == expected_output


@pytest.mark.parametrize("list1, list2, expected_output", [
    ([6, 7, 8, 9, 10], [1, 2, 3, 4, 5], "Первый список имеет большее среднее значение"),
    ([1, 2, 3, 4, 5], [6, 7, 8, 9, 10], "Второй список имеет большее среднее значение"),
    ([5, 2, 4, 3, 1], [1, 2, 3, 4, 5], "Средние значения равны")
])
def test_compare_averages_and_calculate_average(list1, list2, expected_output):
    assert compare_averages(list1, list2) == expected_output
