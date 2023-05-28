package in.neuron.ai;

import java.util.Arrays;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sorted array
        int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("Target value found at index " + index);
        } else {
            System.out.println("Target value not found in the array.");
        }

        scanner.close();
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target value not found
    }
}

