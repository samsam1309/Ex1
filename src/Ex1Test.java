import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Ex1Test {

    @Test
    public void testNumber2Int() {
        assertEquals(9, Ex1.number2Int("1001b2"));
        assertEquals(120, Ex1.number2Int("AAbB"));
        assertEquals(-1, Ex1.number2Int("1b")); // Invalid format
        assertEquals(-1, Ex1.number2Int("1234b11")); // Invalid base
    }

    @Test
    public void testIsNumber() {
        assertTrue(Ex1.isNumber("1001b2"));
        assertTrue(Ex1.isNumber("AAbB"));
        assertFalse(Ex1.isNumber("1b"));
        assertFalse(Ex1.isNumber("123b11"));
    }

    @Test
    public void testInt2Number() {
        assertEquals("1001", Ex1.int2Number(9, 2));
        assertEquals("7A", Ex1.int2Number(120, 16));
        assertEquals("", Ex1.int2Number(-1, 10)); // Invalid input
    }

    @Test
    public void testEquals() {
        assertTrue(Ex1.equals("1001b2", "9b10"));
        assertFalse(Ex1.equals("1001b2", "11b2"));
    }

    @Test
    public void testMaxIndex() {
        String[] numbers = {"1001b2", "11b3", "123bA", "EFbG"};
        assertEquals(3, Ex1.maxIndex(numbers)); // "EFbG" is the largest
    }
}
