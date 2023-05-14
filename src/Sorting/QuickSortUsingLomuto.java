package Sorting;

import java.util.*;

public class QuickSortUsingLomuto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        // take input array
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // sort the array using quick sort
        qSort(arr, 0, n - 1);

        // print the sorted array
        for (int x : arr)
            System.out.print(x + " ");
        sc.close();
    }

    // method to perform quick sort
    public static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            // partition the array using lomuto partition
            int p = lomutoPartition(arr, low, high);

            // recursively sort the left and right partitions
            qSort(arr, low, p - 1);
            qSort(arr, p + 1, high);
        }
    }

    // method to perform lomuto partition
    public static int lomutoPartition(int[] arr, int low, int high) {
        // choose pivot element as the last element of the array
        int pivot = arr[high];

        // initialize index i to be one less than the start index
        int i = low - 1;

        // loop through the array from start index to end index
        for (int j = low; j < high; j++) {
            // if the current element is less than the pivot, swap it with the element at index i+1
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap the pivot element with the element at index i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the index of the pivot element
        return i + 1;
    }
}
