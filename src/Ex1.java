/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over bases from binary to hexadecimal.
 * [2-16], 10-16 are represented by A, B, ..., G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, return -1.
     *
     * @param str a String representing a number in basis [2,16]
     * @return the decimal value of the number or -1 if invalid
     */
    public static int number2Int(String str) {
        // Checks if the string is null or empty
        if (str == null || str.isEmpty()) {
            return -1;
        }

        // Checks if the string is in a valid format using the isNumber function
        if (!isNumber(str)) {
            return -1; // Returns -1 if the string is invalid
        }

        // Splits the string into two parts: number and base
        String[] parts = str.split("b");
        String numberPart = parts[0]; // Part before 'b' (the number)
        String basePart = parts[1];   // Part after 'b' (the base)

        // Converts the base to an integer
        int base;
        try {
            base = Integer.parseInt(basePart);
            if (base < 2 || base > 16) {
                return -1; // If the base is out of range, return -1
            }
        } catch (NumberFormatException e) {
            return -1; // If the base is not a valid integer, return -1
        }

        // Converts the number to base 10
        try {
            return Integer.parseInt(numberPart, base); // Uses Integer.parseInt with the specified base
        } catch (NumberFormatException e) {
            return -1; // If the number is invalid, return -1
        }
    }

    /**
     * This static function checks if the given String (a) is in a valid "number" format.
     *
     * @param str a String representing a number
     * @return true if the given String is in a valid number format
     */
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty() || !str.contains("b")) {
            return false;
        }

        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false; // If the format is invalid
        }

        // Checks if the base is valid
        try {
            int base = Integer.parseInt(parts[1]);
            if (base < 2 || base > 16) {
                return false; // Base out of range
            }
        } catch (NumberFormatException e) {
            return false; // Invalid base
        }

        // Checks if the number is valid for the base
        try {
            Integer.parseInt(parts[0], Integer.parseInt(parts[1]));
        } catch (NumberFormatException e) {
            return false; // Invalid number
        }

        return true; // Everything is valid
    }

    /**
     * Calculate the number representation (in the specified base)
     * of the given natural number (represented as an integer).
     * If num < 0 or base is not in [2,16], the function should return "" (empty String).
     *
     * @param num  the natural number (including 0)
     * @param base the basis [2,16]
     * @return a String representing the number in the given base or "" if invalid
     */
    public static String int2Number(int num, int base) {
        // Add your code here
        if (base < 2 || base > 16 || num < 0) {
            return "";
        }

        // Converts the number to the specified base
        String numberInBase = Integer.toString(num, base).toUpperCase();

        return numberInBase;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    /**
     * This static function searches for the array index with the largest number (in value).
     * If there are multiple maximums, return the first index.
     * Note: The array is not null and not empty, but it may contain null or invalid numbers (value -1).
     *
     * @param arr an array of numbers
     * @return the index of the largest number (by value)
     */
    public static int maxIndex(String[] arr) {
        int maxValue = -1; // Initial maximum value
        int maxIndex = -1; // Index of the maximum

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]); // Convert each number to base 10

            // If the value is valid and greater than the current maximum
            if (value != -1 && value > maxValue) {
                maxValue = value;  // Update the maximum value
                maxIndex = i;      // Update the index of the maximum
            }
        }

        return maxIndex; // Return the index of the largest number
    }

}
