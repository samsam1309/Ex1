
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
        if (str == null || str.isEmpty() || !str.contains("b")) {
            return -1; // Format invalide
        }

        // Divise la chaîne en deux parties : nombre et base
        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return -1; // Format invalide
        }

        String numberPart = parts[0].toUpperCase(); // Convertit en majuscules pour gérer les lettres
        int base;
        try {
            base = Integer.parseInt(parts[1]);
            if (base < 2 || base > 16) {
                return -1; // Base hors limites
            }
        } catch (NumberFormatException e) {
            return -1; // Base invalide
        }

        // Vérifie et convertit le nombre
        int result = 0;
        try {
            for (char c : numberPart.toCharArray()) {
                int digitValue;
                if (Character.isDigit(c)) {
                    digitValue = c - '0'; // Valeur numérique des chiffres
                } else if (c >= 'A' && c <= 'F') {
                    digitValue = c - 'A' + 10; // Valeur numérique des lettres
                } else {
                    return -1; // Caractère invalide
                }
                if (digitValue >= base) {
                    return -1; // Chiffre invalide pour la base
                }
                result = result * base + digitValue; // Conversion progressive
            }
        } catch (Exception e) {
            return -1; // En cas d'erreur inattendue
        }

        return result;
    }


    /**
     * This static function checks if the given String (a) is in a valid "number" format.
     *
     * @param str a String representing a number
     * @return true if the given String is in a valid number format
     */
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty() || !str.contains("b")) {
            return false; // Format invalide
        }

        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false; // Format invalide
        }

        String numberPart = parts[0].toUpperCase();
        int base;
        try {
            base = Integer.parseInt(parts[1]);
            if (base < 2 || base > 16) {
                return false; // Base hors limites
            }
        } catch (NumberFormatException e) {
            return false; // Base invalide
        }

        for (char c : numberPart.toCharArray()) {
            if (Character.isDigit(c)) {
                if (c - '0' >= base) return false; // Chiffre hors limites
            } else if (c >= 'A' && c <= 'F') {
                if (c - 'A' + 10 >= base) return false; // Lettre hors limites
            } else {
                return false; // Caractère invalide
            }
        }

        return true;
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
        if (num < 0 || base < 2 || base > 16) {
            return ""; // Entrée invalide
        }

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
            result.insert(0, digit);
            num /= base;
        }

        return result.length() > 0 ? result.toString() : "0"; // Gère le cas où num = 0
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
        int maxValue = -1; // Initialise à une valeur invalid
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }

        return maxIndex;
    }


}