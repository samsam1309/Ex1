import java.util.Scanner;

public class Ex1Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        System.out.println("Ex1 class solution:");

        while (true) {
            // Demander à l'utilisateur de saisir le premier nombre
            System.out.println("\nEnter a string as number#1 (NUMBERbBASE) (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (num1.equals(quit)) {
                break; // Quitter si l'utilisateur entre "quit"
            }

            // Demander à l'utilisateur de saisir le deuxième nombre
            System.out.println("Enter a string as number#2 (NUMBERbBASE) (or \"quit\" to end the program): ");
            num2 = sc.next();

            if (num2.equals(quit)) {
                break; // Quitter si l'utilisateur entre "quit"
            }

            // Conversion des numéros en entier
            int number1 = Ex1.number2Int(num1);
            int number2 = Ex1.number2Int(num2);

            // Vérifier si les conversions sont valides
            if (number1 != -1 && number2 != -1) {
                System.out.println("Number 1 (" + num1 + ") in decimal: " + number1);
                System.out.println("Number 2 (" + num2 + ") in decimal: " + number2);

                // Vérification de l'égalité des deux nombres
                if (Ex1.equals(num1, num2)) {
                    System.out.println("The numbers are equal!");
                } else {
                    System.out.println("The numbers are NOT equal!");
                }

                // Affichage des conversions dans d'autres bases
                System.out.println("Number 1 (" + num1 + ") in base 2: " + Ex1.int2Number(number1, 2));
                System.out.println("Number 1 (" + num1 + ") in base 16: " + Ex1.int2Number(number1, 16));
                System.out.println("Number 2 (" + num2 + ") in base 2: " + Ex1.int2Number(number2, 2));
                System.out.println("Number 2 (" + num2 + ") in base 16: " + Ex1.int2Number(number2, 16));
            } else {
                System.out.println("Invalid input! One or both numbers could not be converted.");
            }

            // Demander si l'utilisateur souhaite continuer ou non
            System.out.println("Do you want to enter more numbers? (yes/no)");
            String continueInput = sc.next();
            if (continueInput.equalsIgnoreCase("no")) {
                break; // Sortir de la boucle
            }
        }

        // Exemple d'utilisation de la fonction maxIndex sur un tableau d'entrées
        System.out.println("\nEnter a list of numbers in the format NUMBERbBASE (separated by space) to find the largest number's index, or \"quit\" to exit:");
        sc.nextLine(); // Consommer le retour à la ligne restant
        String inputList = sc.nextLine(); // Lire toute la ligne (par exemple "123b10 456b2 89b16")

        if (!inputList.equals("quit")) {
            String[] numbersArray = inputList.split(" "); // Diviser les nombres par espace
            int maxIndex = Ex1.maxIndex(numbersArray); // Utiliser la fonction maxIndex

            if (maxIndex != -1) {
                System.out.println("The index of the largest number is: " + maxIndex);
            } else {
                System.out.println("No valid numbers were found.");
            }
        }

        // Fermeture du scanner
        System.out.println("Quitting now...");
        sc.close();
    }
}
