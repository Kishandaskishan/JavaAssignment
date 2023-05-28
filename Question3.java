package in.neuron.ai;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a positive number: ");
            int number = scanner.nextInt();

            if (number < 0) {
                throw new NegativeNumberException("Negative numbers are not allowed!");
            }

            System.out.println("Entered number: " + number);
        } catch (NegativeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Custom exception class for negative numbers
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
