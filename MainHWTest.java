import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.MainHW;


public class MainHWTest {

    @ParameterizedTest
    @ValueSource(ints = {-2,0, 2, 4, 6, 8, 10})
    public void testIsEvenWithEvenNumbers(int number) {
        assertEquals(true, MainHW.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-11, -1, 1, 3, 5, 7, 9})
    public void testIsEvenWithOddNumbers(int number) {
        assertEquals(false, MainHW.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(floats = {30.5f, 50.75f, 99.2f})
    public void testIsInRangeWithValidFloats(float number) {
        assertEquals(true, MainHW.numberInInterval(number));
    }

    @ParameterizedTest
    @ValueSource(floats = {10.25f, 15.9f, 25.0f, 100.0f, 110.0f})
    public void testIsInRangeWithInvalidFloats(float number) {
        assertEquals(false, MainHW.numberInInterval(number));
    }
}
