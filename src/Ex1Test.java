import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Ex1Test {

    @Test
    public void testNumber2Int() {
        // Tests déjà existants
        assertEquals(9, Ex1.number2Int("1001b2"));
        assertEquals(-1, Ex1.number2Int("1b")); // Format invalide

        // Tests avec des lettres dans le nombre ou la base
        assertEquals(-1, Ex1.number2Int("ABC123b3")); // Lettres dans la partie nombre
        assertEquals(-1, Ex1.number2Int("123abcB3")); // Lettres dans la base
        assertEquals(-1, Ex1.number2Int("12bX")); // Lettres dans la base
        assertEquals(-1, Ex1.number2Int("abc12b12")); // Lettres dans la partie nombre et base
    }

    @Test
    public void testIsNumber() {
        // Tests déjà existants
        assertTrue(Ex1.isNumber("1001b2"));
        assertFalse(Ex1.isNumber("1b"));

        // Tests avec des lettres dans le nombre ou la base
        assertFalse(Ex1.isNumber("abc123b3")); // Lettres dans la partie nombre
        assertFalse(Ex1.isNumber("123abcB3")); // Lettres dans la base
        assertFalse(Ex1.isNumber("12bX")); // Lettres dans la base
        assertFalse(Ex1.isNumber("abc12b12")); // Lettres dans la partie nombre et base
    }

    @Test
    public void testInt2Number() {
        // Tests déjà existants
        assertEquals("1001", Ex1.int2Number(9, 2));
        assertEquals("", Ex1.int2Number(-1, 10)); // Invalid input

        // Tests supplémentaires avec des bases valides
        assertEquals("A", Ex1.int2Number(10, 16)); // Base 16 (10 en décimal = A en hexadécimal)

        // Tests invalides avec des lettres dans la base ou le nombre
        assertEquals("", Ex1.int2Number(10, 1)); // Base 1 n'est pas valide
    }

    @Test
    public void testEquals() {
        // Tests déjà existants
        assertTrue(Ex1.equals("1001b2", "9b10"));
        assertFalse(Ex1.equals("1001b2", "11b2"));

        // Tests supplémentaires avec des lettres dans la base
        assertTrue(Ex1.equals("A1b16", "161b10")); // 161 en base 10 est égal à A1 en base 16
        assertFalse(Ex1.equals("100b2", "11b3"));  // Deux nombres différents

        // Tests avec des lettres dans les deux parties (nombre et base)
        assertFalse(Ex1.equals("abc123bX", "123abcB3")); // Lettres dans les deux parties
    }

    @Test
    public void testMaxIndex() {
        String[] numbers = {"1001b2", "11b3", "123bA", "EFbG"};
        assertEquals(3, Ex1.maxIndex(numbers)); // "EFbG" is the largest

        // Tests supplémentaires avec des lettres dans le nombre ou la base
        String[] numbers2 = {"abc123b3", "12bX", "123b12", "a1b2"};
        assertEquals(-1, Ex1.maxIndex(numbers2)); // Aucune valeur valide, donc retour -1

        String[] numbers3 = {"100b2", "abc", "1b1", "999b10"};
        assertEquals(3, Ex1.maxIndex(numbers3)); // "999b10" is the largest
    }
}
