import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Ex1Test {

    @Test
    public void testNumber2Int() {
        // Existing tests
        assertEquals(9, Ex1.number2Int("1001b2"));
        assertEquals(-1, Ex1.number2Int("1b")); // Invalid format

        // Tests with letters in the number or base
        assertEquals(-1, Ex1.number2Int("ABC123b3")); // Letters in the number part
        assertEquals(-1, Ex1.number2Int("123abcB3")); // Letters in the base part
        assertEquals(-1, Ex1.number2Int("12bX")); // Letters in the base part
        assertEquals(-1, Ex1.number2Int("abc12b12")); // Letters in both the number and base parts
    }

    @Test
    public void testIsNumber() {
        // Existing tests
        assertTrue(Ex1.isNumber("1001b2"));
        assertFalse(Ex1.isNumber("1b"));

        // Tests with letters in the number or base
        assertFalse(Ex1.isNumber("abc123b3")); // Letters in the number part
        assertFalse(Ex1.isNumber("123abcB3")); // Letters in the base part
        assertFalse(Ex1.isNumber("12bX")); // Letters in the base part
        assertFalse(Ex1.isNumber("abc12b12")); // Letters in both the number and base parts
    }

    @Test
    public void testInt2Number() {
        // Existing tests
        assertEquals("1001", Ex1.int2Number(9, 2));
        assertEquals("", Ex1.int2Number(-1, 10)); // Invalid input

        // Additional tests with valid bases
        assertEquals("A", Ex1.int2Number(10, 16)); // Base 16 (10 in decimal = A in hexadecimal)

        // Invalid tests with letters in the base or number
        assertEquals("", Ex1.int2Number(10, 1)); // Base 1 is not valid
    }

    @Test
    public void testEquals() {
        // Existing tests
        assertTrue(Ex1.equals("1001b2", "9b10"));
        assertFalse(Ex1.equals("1001b2", "11b2"));

        // Additional tests with letters in the base
        assertTrue(Ex1.equals("A1b16", "161b10")); // 161 in base 10 is equal to A1 in base 16

        // Tests with letters in both parts (number and base)
    }

    @Test
    public void testMaxIndex() {
        String[] numbers = {"1001b2", "11b3", "123bA", "EFbG"};
        assertEquals(3, Ex1.maxIndex(numbers)); // "EFbG" is the largest

        // Additional tests with letters in the number or base
        String[] numbers2 = {"abc123b3", "12bX", "123b12", "a1b2"};

        String[] numbers3 = {"100b2", "abc", "1b1", "999b10"};
    }
}
