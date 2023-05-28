package in.neuron.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        int secondLargest = findSecondLargest(numbers);
        int secondSmallest = findSecondSmallest(numbers);

        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Second Smallest: " + secondSmallest);

        scanner.close();
    }

    public static int findSecondLargest(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(numbers.size() - 2);
    }

    public static int findSecondSmallest(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(1);
    }
}
