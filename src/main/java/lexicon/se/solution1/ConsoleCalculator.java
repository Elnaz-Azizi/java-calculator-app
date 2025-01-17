package lexicon.se.solution1;

import java.util.InputMismatchException;
import java.util.Scanner;


// ConsoleCalculator class provides a console-based interface for a calculator application.
public class ConsoleCalculator  {


    // Main method to run the calculator
    public static void runCalculator() {
        Scanner scanner = new Scanner(System.in);

        boolean continueRunning = true;

        while (continueRunning) {
            try {
                // First, display the operation menu and ask for the operation
                displayMenu();
                String operation =  scanner.nextLine();

                // Check if the user chose to exit
                if (operation.equalsIgnoreCase("exit")) {
                    continueRunning = false; // Exit the loop
                    break; // Ensure that it immediately exits and doesn't ask for numbers
                }

                // Handle multiple inputs for addition
                if (operation.equals("+")) {
                    performAddition(); // Handles multiple number addition
                } else {
                    // Otherwise, ask for two numbers for other operations
                    int firstNumber = getNumber("Enter the first number: ");
                    int secondNumber = getNumber("Enter the second number: ");
                    performOperation(firstNumber, secondNumber, operation);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.nextLine(); // clear the invalid input
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Calculator application ended.");
    }

    // Method to display the calculator menu
    private static void displayMenu() {
        System.out.println("===== Calculator Menu =====");
        System.out.println("Choose an operation:");
        System.out.println("+ (Addition - Enter multiple numbers, use '=' to calculate)");
        System.out.println("- (Subtraction)");
        System.out.println("* (Multiplication)");
        System.out.println("/ (Division)");
        System.out.println("exit (Exit the calculator)");
        System.out.println("============================");
    }

    // Method to get the user's operation input
    private static String getUserOperation() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Method to perform the selected operation (except addition with multiple inputs)
    private static void performOperation(int num1, int num2, String operation) {
        switch (operation) {
            case "-":
                System.out.println("Result: " + MathOperations.subtract(num1, num2));
                break;
            case "*":
                System.out.println("Result: " + MathOperations.multiply(num1, num2));
                break;
            case "/":
                System.out.println("Result: " + MathOperations.divide(num1, num2));
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
        }
    }

    // Method to perform the addition of multiple numbers
    private static void performAddition() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (true) {
            System.out.print("Enter a number (or type '=' to calculate): ");
            String input = scanner.nextLine();

            if (input.equals("=")) {
                System.out.println("Result: " + sum);
                break; // Exit the loop once '=' is entered
            }

            try {
                int number = Integer.parseInt(input);
                sum += number; // Add the number to the sum
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or '=' to calculate.");
            }
        }
    }

    // Method to get a single numeric input from the user
    private static int getNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        int number = scanner.nextInt();
        scanner.nextLine();  // Clear the newline character left in the buffer
        return number;
    }

}
