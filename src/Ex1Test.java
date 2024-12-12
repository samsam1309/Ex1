import org.junit.Test;
import static org.junit.Assert.*;

public class Ex1Test {

    @Test
    public void testNumber2Int() {
        // Test conversion from various bases to base 10
        assertEquals(255, Ex1.number2Int("FFb16")); // Hexadecimal to decimal
        assertEquals(11, Ex1.number2Int("1011b2")); // Binary to decimal
        assertEquals(63, Ex1.number2Int("77b8")); // Octal to decimal

        // Invalid inputs
        assertEquals(-1, Ex1.number2Int("123b1")); // Base too low
        assertEquals(-1, Ex1.number2Int("G5b16")); // Invalid character for base 16
    }

    @Test
    public void testInt2Number() {
        // Test conversion from base 10 to other bases
        assertEquals("FF", Ex1.int2Number(255, 16)); // Decimal to hexadecimal
        assertEquals("1011", Ex1.int2Number(11, 2)); // Decimal to binary
        assertEquals("77", Ex1.int2Number(63, 8)); // Decimal to octal

        // Invalid inputs
        assertEquals("", Ex1.int2Number(-10, 10)); // Negative number
        assertEquals("", Ex1.int2Number(10, 20)); // Base out of range
    }

    @Test
    public void testIsNumber() {
        // Valid numbers
        assertTrue(Ex1.isNumber("FFb16")); // Hexadecimal
        assertTrue(Ex1.isNumber("1011b2")); // Binary

        // Invalid numbers
        assertFalse(Ex1.isNumber("123b1")); // Base too low
        assertFalse(Ex1.isNumber("G5b16")); // Invalid character for base 16
        assertFalse(Ex1.isNumber("1011")); // Missing base part
    }

    @Test
    public void testIsDecimalNumber() {
        // Valid decimal number
        assertTrue(Ex1.isDecimalNumber("123"));

        // Invalid decimal numbers
        assertFalse(Ex1.isDecimalNumber("123b10")); // Contains base notation
        assertFalse(Ex1.isDecimalNumber("12.3")); // Contains decimal point
        assertFalse(Ex1.isDecimalNumber("ABC")); // Alphabetic string
    }

    @Test
    public void testMaxIndex() {
        // Array with numbers in base 10
        String[] numbers1 = {"10", "20", "30", "25"};
        assertEquals(2, Ex1.maxIndex(numbers1)); // "30" is the maximum value (index 2)

        // Array with numbers in various bases
        String[] numbers2 = {"10b2", "FFb16", "77b8", "63b10"};
        assertEquals(1, Ex1.maxIndex(numbers2)); // "FFb16" (255 in decimal) is the maximum value (index 1)

        // Array with identical values
        String[] numbers3 = {"1", "1", "1"};
        assertEquals(0, Ex1.maxIndex(numbers3)); // First index is the maximum

        // Empty array
        String[] numbers4 = {};
        assertEquals(-1, Ex1.maxIndex(numbers4)); // Returns -1 for an empty array
    }


    @Test
    public void testEquals() {
        // Test if two numbers are equal when converted to base 10
        assertTrue(Ex1.equals("101b2", "5b10")); // Binary equals decimal
        assertTrue(Ex1.equals("FFb16", "255b10")); // Hexadecimal equals decimal

        // Numbers that are not equal
        assertFalse(Ex1.equals("77b8", "80b10")); // Octal does not equal decimal
        assertFalse(Ex1.equals("123b1", "123")); // Invalid base comparison
        assertFalse(Ex1.equals("123", "123b20")); // Base out of range
    }
}
