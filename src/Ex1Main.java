import java.util.Scanner;
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        System.out.println("Ex1 class solution:");

        while (true) {
            // Ask the user to input the first number
            System.out.println("\nEnter a string as number#1 (NUMBERbBASE) (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (num1.equals(quit)) {
                break; // Exit if the user enters "quit"
            }

            // Ask the user to input the second number
            System.out.println("Enter a string as number#2 (NUMBERbBASE) (or \"quit\" to end the program): ");
            num2 = sc.next();

            if (num2.equals(quit)) {
                break; // Exit if the user enters "quit"
            }

            // Convert the numbers to integers
            int number1 = Ex1.number2Int(num1);
            int number2 = Ex1.number2Int(num2);

            // Check if the conversions are valid
            if (number1 != -1 && number2 != -1) {
                System.out.println("Number 1 (" + num1 + ") in decimal: " + number1);
                System.out.println("Number 2 (" + num2 + ") in decimal: " + number2);

                // Check if the two numbers are equal
                if (Ex1.equals(num1, num2)) {
                    System.out.println("The numbers are equal!");
                } else {
                    System.out.println("The numbers are NOT equal!");
                }

                // Display the conversions in other bases
                System.out.println("Number 1 (" + num1 + ") in base 2: " + Ex1.int2Number(number1, 2));
                System.out.println("Number 1 (" + num1 + ") in base 16: " + Ex1.int2Number(number1, 16));
                System.out.println("Number 2 (" + num2 + ") in base 2: " + Ex1.int2Number(number2, 2));
                System.out.println("Number 2 (" + num2 + ") in base 16: " + Ex1.int2Number(number2, 16));
            } else {
                System.out.println("Invalid input! One or both numbers could not be converted.");
            }

            // Ask if the user wants to continue or not
            System.out.println("Do you want to enter more numbers? (yes/no)");
            String continueInput = sc.next();
            if (continueInput.equalsIgnoreCase("no")) {
                break; // Exit the loop
            }
        }

        // Example of using the maxIndex function on a list of inputs
        System.out.println("\nEnter a list of numbers in the format NUMBERbBASE (separated by space) to find the largest number's index, or \"quit\" to exit:");
        sc.nextLine(); // Consume the leftover newline
        String inputList = sc.nextLine(); // Read the entire line (e.g., "123b10 456b2 89b16")

        if (!inputList.equals("quit") && !inputList.isEmpty()) {
            String[] numbersArray = inputList.split(" "); // Split the numbers by space
            int maxIndex = Ex1.maxIndex(numbersArray); // Use the maxIndex function

            if (maxIndex != -1) {
                System.out.println("The index of the largest number is: " + maxIndex);
            } else {
                System.out.println("No valid numbers were found.");
            }
        } else {
            System.out.println("No valid input for the list.");
        }

        // Close the scanner
        System.out.println("Quitting now...");
        sc.close();
    }
}
