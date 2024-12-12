import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        System.out.println("Ex1 class solution:");

        while (true) {
            // Ask for the first number
            System.out.println("\nEnter a string as number#1 (NUMBERbBASE) or a decimal number (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals(quit)) break;

            // Validate and display the result in decimal
            boolean isValid1 = Ex1.isNumber(num1);
            int number1 = isValid1 ? Ex1.number2Int(num1) : (Ex1.isDecimalNumber(num1) ? Integer.parseInt(num1) : -1);

            System.out.println("Your Number " + num1 + " is valid: " + (number1 != -1));
            if (number1 != -1) {
                System.out.println("In decimal: " + number1);
            } else {
                System.out.println("Invalid number format for number 1.");
                continue;
            }

            // Ask for the second number
            System.out.println("Enter a string as number#2 (NUMBERbBASE) or a decimal number (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) break;

            // Validate and display the result in decimal
            boolean isValid2 = Ex1.isNumber(num2);
            int number2 = isValid2 ? Ex1.number2Int(num2) : (Ex1.isDecimalNumber(num2) ? Integer.parseInt(num2) : -1);

            System.out.println("Your Number " + num2 + " is valid: " + (number2 != -1));
            if (number2 != -1) {
                System.out.println("In decimal: " + number2);
            } else {
                System.out.println("Invalid number format for number 2.");
                continue;
            }

            // Ask for the base to display the results in
            System.out.println("Enter the base (between 2 and 16) for the results: ");
            int base = sc.nextInt();

            // Check if the base is valid
            if (base < 2 || base > 16) {
                System.out.println("Invalid base! Please enter a base between 2 and 16.");
                continue;
            }

            // Calculate the sum and product in the specified base
            int sum = number1 + number2;
            int product = number1 * number2;

            System.out.println("Sum in base " + base + ": " + Ex1.int2Number(sum, base) + "b" + base);
            System.out.println("Product in base " + base + ": " + Ex1.int2Number(product, base) + "b" + base);

            // Find the index of the maximum value among the four values
            String[] numbers = {
                    String.valueOf(number1),
                    String.valueOf(number2),
                    String.valueOf(sum),
                    String.valueOf(product)
            };
            int maxIndex = Ex1.maxIndex(numbers);

            System.out.println("The index of the largest number among the four values is: " + maxIndex);

            // Ask if the user wants to input more numbers
            System.out.println("Do you want to enter more numbers? (yes/no)");
            String continueInput = sc.next();
            if (continueInput.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("Quitting now...");
        sc.close();
    }
}
