
public class Ex1 {

    public static int number2Int(String str) {
        if (str == null || str.isEmpty() || !str.contains("b")) {
            return -1;
        }

        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return -1;
        }

        String numberPart = parts[0].toUpperCase();
        int base;

        try {
            base = Integer.parseInt(parts[1]);
            if (base < 2 || base > 16) {
                return -1;
            }
        } catch (NumberFormatException e) {
            return -1;
        }

        int result = 0;
        for (char c : numberPart.toCharArray()) {
            int digitValue = getDigitValue(c);
            if (digitValue == -1 || digitValue >= base) {
                return -1;
            }
            result = result * base + digitValue;
        }

        return result;
    }

    private static int getDigitValue(char c) {
        if (Character.isDigit(c)) {
            return c - '0';
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        } else {
            return -1;
        }
    }

    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        do {
            int remainder = num % base;
            char digit = (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + (remainder - 10));
            result.insert(0, digit);
            num /= base;
        } while (num > 0);

        return result.toString();
    }

    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty() || !str.contains("b")) {
            return false;
        }

        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false;
        }

        try {
            int base = Integer.parseInt(parts[1]);
            if (base < 2 || base > 16) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        for (char c : parts[0].toUpperCase().toCharArray()) {
            int digitValue = getDigitValue(c);
            if (digitValue == -1) {
                return false;
            }
        }

        return true;
    }

    public static boolean isDecimalNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean equals(String num1, String num2) {
        // Vérifier si les deux nombres sont valides
        if (!isNumber(num1) || !isNumber(num2)) {
            return false;
        }

        // Convertir les deux nombres en base 10
        int value1 = number2Int(num1);
        int value2 = number2Int(num2);

        // Comparer les deux valeurs
        return value1 == value2;
    }


    public static int maxIndex(String[] arr) {
        int maxValue = -1;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            int value = isDecimalNumber(arr[i]) ? Integer.parseInt(arr[i]) : number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
