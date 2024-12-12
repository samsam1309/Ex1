import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        System.out.println("Ex1 class solution:");

        while (true) {
            // Demander le premier nombre
            System.out.println("\nEnter a string as number#1 (NUMBERbBASE) or a decimal number (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals(quit)) break;

            // Vérifier la validité et afficher le résultat en base 10
            boolean isValid1 = Ex1.isNumber(num1);
            int number1 = isValid1 ? Ex1.number2Int(num1) : (Ex1.isDecimalNumber(num1) ? Integer.parseInt(num1) : -1);

            System.out.println("Your Number " + num1 + " is valid: " + (number1 != -1));
            if (number1 != -1) {
                System.out.println("In decimal: " + number1);
            } else {
                System.out.println("Invalid number format for number 1.");
                continue;
            }

            // Demander le deuxième nombre
            System.out.println("Enter a string as number#2 (NUMBERbBASE) or a decimal number (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) break;

            // Vérifier la validité et afficher le résultat en base 10
            boolean isValid2 = Ex1.isNumber(num2);
            int number2 = isValid2 ? Ex1.number2Int(num2) : (Ex1.isDecimalNumber(num2) ? Integer.parseInt(num2) : -1);

            System.out.println("Your Number " + num2 + " is valid: " + (number2 != -1));
            if (number2 != -1) {
                System.out.println("In decimal: " + number2);
            } else {
                System.out.println("Invalid number format for number 2.");
                continue;
            }

            // Demander la base dans laquelle afficher les résultats
            System.out.println("Enter the base (between 2 and 16) for the results: ");
            int base = sc.nextInt();

            // Vérifier si la base est valide
            if (base < 2 || base > 16) {
                System.out.println("Invalid base! Please enter a base between 2 and 16.");
                continue;
            }

            // Calculer la somme et le produit dans la base demandée
            int sum = number1 + number2;
            int product = number1 * number2;

            System.out.println("Sum in base " + base + ": " + Ex1.int2Number(sum, base));
            System.out.println("Product in base " + base + ": " + Ex1.int2Number(product, base));

            // Trouver l'indice du maximum entre les 4 valeurs
            String[] numbers = {
                    String.valueOf(number1),
                    String.valueOf(number2),
                    String.valueOf(sum),
                    String.valueOf(product)
            };
            int maxIndex = Ex1.maxIndex(numbers);

            System.out.println("The index of the largest number among the four values is: " + maxIndex);

            // Demander si l'utilisateur veut entrer d'autres nombres
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
