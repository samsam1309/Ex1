public class Ex1 {

    // Converts a number in string format with base (e.g., "101b2") to decimal integer
    public static int number2Int(String str) {
        // Check if the string is null, empty, or doesn't contain 'b' to indicate base
        if (str == null || str.isEmpty() || !str.contains("b")) {
            return -1;
        }

        // Split the string into number part and base part
        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return -1;
        }

        String numberPart = parts[0].toUpperCase();
        int base;

        try {
            base = Integer.parseInt(parts[1]); // Try to parse the base
            if (base < 2 || base > 16) { // Check if base is within valid range
                return -1;
            }
        } catch (NumberFormatException e) {
            return -1; // Return -1 if base is not a valid number
        }

        int result = 0;
        // Convert each character in the number part to its corresponding digit value
        for (char c : numberPart.toCharArray()) {
            int digitValue = getDigitValue(c);
            if (digitValue == -1 || digitValue >= base) {
                return -1; // Invalid digit for the given base
            }
            result = result * base + digitValue;
        }

        return result;
    }

    // Helper method to get the digit value for a character
    private static int getDigitValue(char c) {
        if (Character.isDigit(c)) {
            return c - '0'; // Return the digit value for 0-9
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10; // Return the digit value for A-F (hexadecimal digits)
        } else {
            return -1; // Return -1 for invalid characters
        }
    }

    // Converts a decimal integer to a number in the specified base (between 2 and 16)
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return ""; // Return an empty string for invalid inputs
        }

        StringBuilder result = new StringBuilder();
        // Convert the number to the specified base
        do {
            int remainder = num % base;
            char digit = (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + (remainder - 10));
            result.insert(0, digit); // Insert the digit at the beginning of the result
            num /= base;
        } while (num > 0);

        return result.toString();
    }

    // Checks if the string represents a valid number in a given base format
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty() || !str.contains("b")) {
            return false; // Return false if the string doesn't contain 'b'
        }

        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false; // Return false if the format is incorrect
        }

        try {
            int base = Integer.parseInt(parts[1]); // Try to parse the base
            if (base < 2 || base > 16) {
                return false; // Return false if base is not valid
            }
        } catch (NumberFormatException e) {
            return false; // Return false if base parsing fails
        }

        // Check if all characters in the number part are valid digits for the base
        for (char c : parts[0].toUpperCase().toCharArray()) {
            int digitValue = getDigitValue(c);
            if (digitValue == -1) {
                return false; // Return false if any character is invalid
            }
        }

        return true;
    }

    // Checks if the string is a valid decimal number
    public static boolean isDecimalNumber(String str) {
        try {
            Integer.parseInt(str); // Try to parse the string as a decimal integer
            return true;
        } catch (NumberFormatException e) {
            return false; // Return false if parsing fails
        }
    }

    // Compares two numbers (in string format) to see if they are equal
    public static boolean equals(String num1, String num2) {
        // Check if both numbers are valid
        if (!isNumber(num1) || !isNumber(num2)) {
            return false;
        }

        // Convert both numbers to base 10
        int value1 = number2Int(num1);
        int value2 = number2Int(num2);

        // Return true if the values are equal, false otherwise
        return value1 == value2;
    }

    // Finds the index of the maximum value in an array of numbers (string format)
    public static int maxIndex(String[] arr) {
        int maxValue = -1;
        int maxIndex = -1;

        // Iterate through the array and compare each value
        for (int i = 0; i < arr.length; i++) {
            int value = isDecimalNumber(arr[i]) ? Integer.parseInt(arr[i]) : number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i; // Track the index of the maximum value
            }
        }

        return maxIndex; // Return the index of the maximum value
    }
}
