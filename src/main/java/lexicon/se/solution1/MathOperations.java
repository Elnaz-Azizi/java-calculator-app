package se.lexicon.part1.workshop.solution1;

public class MathOperations {

    // Method to handle addition of multiple numbers
    public static int add(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method to handle subtraction of multiple numbers
    public static int subtract(int... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    // Method for multiplication of two numbers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Method for division of two numbers
    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }


}
