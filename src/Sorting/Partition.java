package Sorting;

import java.util.*;

public class Partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Sorting using Lomuto partition algorithm
        lomuto(arr, 0, n - 1);
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();

        // Sorting using Hoare partition algorithm
        hoare(arr, 0, n - 1);
        for (int i : arr)
            System.out.print(i + " ");

        // Closing the scanner object
        sc.close();
    }

    // Lomuto partition algorithm
    public static int lomuto(int[] arr, int low, int high) {
        // Choosing pivot element
        int pivot = arr[high];

        // Initializing i to one less than the lowest index
        int i = low - 1;

        // Looping through the array
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swapping i and j elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Placing pivot element in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Returning the position of pivot element
        return i + 1;
    }

    // Hoare partition algorithm
    public static int hoare(int[] arr, int low, int high) {
        // Choosing pivot element
        int pivot = arr[low];

        // Initializing i to lowest index and j to highest index
        int i = low - 1, j = high + 1;

        // Looping through the array
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            // If i and j cross each other, return j
            if (i >= j)
                return j;

            // Swapping i and j elements
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}