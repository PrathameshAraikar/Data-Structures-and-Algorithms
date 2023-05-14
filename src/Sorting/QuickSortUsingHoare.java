/**
 * This program implements QuickSort using Hoare partition scheme and sorts an array of integers in ascending order.
 * Steps:
     * Accepts an array of integers as input.
     * Calls the qSort method which recursively partitions the array using Hoare partition scheme and sorts it.
     * The hoarePartition method selects the pivot element, and rearranges the array elements
     * such that all elements less than pivot are to its left and all elements greater than pivot are to its right.
     * The method then returns the final position of the pivot.
     * The qSort method then recursively calls itself for the left and right subarrays.
     * The sorted array is then printed as output.
 * Time Complexity: O(n log n) in average case, O(n^2) in worst case
 * Space Complexity: O(log n) in average case, O(n) in worst case
 */

package Sorting;

import java.util.*;

public class QuickSortUsingHoare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        qSort(arr, 0, n - 1);
        for (int x : arr)
            System.out.print(x + " ");

        sc.close();
    }

    /**
     * Recursive function to perform quicksort on the array
     *
     * @param arr  The array of integers to be sorted
     * @param low  The starting index of the subarray
     * @param high The ending index of the subarray
     */
    public static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = hoarePartition(arr, low, high);
            qSort(arr, low, p);
            qSort(arr, p + 1, high);
        }
    }

    /**
     * Function to partition the array using Hoare partition scheme
     *
     * @param arr  The array of integers to be sorted
     * @param low  The starting index of the subarray
     * @param high The ending index of the subarray
     * @return The final position of the pivot element
     */
    public static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low], i = low - 1, j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}