package in.neuron.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question6 {
    public static void main(String[] args) {
        // Create a large data set of integers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            numbers.add(i);
        }

        // Use Stream API to sort the data
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted numbers:");
        for (Integer number : sortedNumbers) {
            System.out.println(number);
        }

        // Use Stream API to filter the data
        List<Integer> filteredNumbers = numbers.stream()
                .filter(number -> number % 2 == 0) // Filter even numbers
                .collect(Collectors.toList());

        System.out.println("\nFiltered numbers (even numbers):");
        for (Integer number : filteredNumbers) {
            System.out.println(number);
        }
    }
}

