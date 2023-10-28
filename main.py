def calculate_average(numbers):
    if len(numbers) == 0:
        raise ValueError("Список пуст")

    return sum(numbers) / len(numbers)


def compare_averages(list1, list2):
    result = ""

    try:
        average1 = calculate_average(list1)
        average2 = calculate_average(list2)

        if average1 > average2:
            result = "Первый список имеет большее среднее значение"

        elif average1 < average2:
            result = "Второй список имеет большее среднее значение"

        else:
            result = "Средние значения равны"
    except ValueError as e:
        result = str(e)
    finally:
        print(result)
        return result


if __name__ == '__main__':
    list1 = [1, 2, 3, 4, 5]
    list2 = [6, 7, 8, 9, 10]

    compare_averages(list1, list2)
