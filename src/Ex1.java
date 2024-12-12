
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

        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return -1; // Format invalide
        }

        String numberPart = parts[0].toUpperCase();
        String basePart = parts[1].toUpperCase();
        int base;

        try {
            // Convertit la base de caractère à valeur numérique (A-G = 10-16)
            base = convertBase(basePart);
            if (base < 2 || base > 16) {
                return -1; // Base invalide
            }
        } catch (NumberFormatException e) {
            return -1; // Base invalide
        }

        int result = 0;
        for (char c : numberPart.toCharArray()) {
            int digitValue = getDigitValue(c);
            if (digitValue == -1 || digitValue >= base) {
                return -1; // Caractère invalide ou chiffre trop grand pour la base
            }
            result = result * base + digitValue;
        }

        return result;
    }

    // Fonction auxiliaire pour convertir la base
    private static int convertBase(String basePart) {
        if (basePart.length() == 1 && basePart.charAt(0) >= 'A' && basePart.charAt(0) <= 'G') {
            return basePart.charAt(0) - 'A' + 10; // A=10, B=11, ..., G=16
        } else {
            return Integer.parseInt(basePart); // Traite comme un entier
        }
    }

    // Fonction pour obtenir la valeur numérique d'un caractère
    private static int getDigitValue(char c) {
        if (Character.isDigit(c)) {
            return c - '0';
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        } else {
            return -1; // Caractère invalide
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
            return false;
        }

        String numberPart = parts[0].toUpperCase();
        String basePart = parts[1].toUpperCase();
        int base;

        try {
            base = convertBase(basePart);
            if (base < 2 || base > 16) {
                return false; // Base invalide
            }
        } catch (NumberFormatException e) {
            return false; // Base invalide
        }

        for (char c : numberPart.toCharArray()) {
            int digitValue = getDigitValue(c);
            if (digitValue == -1 || digitValue >= base) {
                return false; // Caractère invalide ou chiffre trop grand pour la base
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
            return ""; // Valeur invalide
        }

        StringBuilder result = new StringBuilder();
        do {
            int remainder = num % base;
            char digit = (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + (remainder - 10));
            result.insert(0, digit);
            num /= base;
        } while (num > 0);

        return result.length() > 0 ? result.toString() : "0";
    }


    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values
     */
    public static boolean equals(String n1, String n2) {
        int value1 = number2Int(n1);
        int value2 = number2Int(n2);
        return value1 != -1 && value1 == value2; // Si l'un des nombres est invalide, on retourne false
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
        int maxValue = -1; // Initialise à une valeur invalide
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