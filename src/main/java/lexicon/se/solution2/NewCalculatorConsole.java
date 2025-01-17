package lexicon.se.solution2;

import java.util.Scanner;

public class CalculatorConsole {

    public static void main(String... args) {
        double currentResult = 0; // Store the running total/result
        String lastOperator = "+"; // Track the last operator (default to '+')

        Scanner scanner = new Scanner(System.in);
        System.out.println("Console Calculator");
        System.out.println("Enter numbers and operators (e.g., 12, +, *, /, ^, %, √).");
        System.out.println("Type 'C' to clear, or 'exit' to quit.");

        while (true) {
            System.out.print("Input: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            } else if (input.equalsIgnoreCase("C")) {
                // Clear everything
                currentResult = 0;
                lastOperator = "+";
                System.out.println("Calculator reset.");
            } else if (input.matches("[0-9.]+")) {
                // Input is a number
                double number = Double.parseDouble(input);
                if (lastOperator.equals("√")) {
                    // Handle square root operator directly
                    currentResult = applySingleOperator(number, "√");
                } else {
                    currentResult = applyOperator(currentResult, number, lastOperator);
                }
                System.out.println("Current Result: " + currentResult);
            } else if (input.matches("[+\\-*/%^√]")) {
                // Input is an operator
                if (input.equals("√")) {
                    // Directly apply square root to the current result
                    currentResult = applySingleOperator(currentResult, "√");
                    System.out.println("Current Result: " + currentResult);
                } else {
                    lastOperator = input;
                    System.out.println("Operator set to: " + lastOperator);
                }
            } else {
                System.out.println("Invalid input. Please enter a number or operator.");
            }
        }
    }

    private static double applyOperator(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                yield a / b;
            }
            case "^" -> Math.pow(a, b);
            case "%" -> a % b;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    private static double applySingleOperator(double a, String operator) {
        return switch (operator) {
            case "√" -> {
                if (a < 0) throw new ArithmeticException("Cannot calculate square root of a negative number");
                yield Math.sqrt(a);
            }
            default -> throw new IllegalArgumentException("Invalid single-operand operator: " + operator);
        };
    }
}
