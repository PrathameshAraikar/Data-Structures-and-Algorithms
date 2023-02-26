package Sorting;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        mergeSort(arr, 0, n-1);
        for(int i: arr)
            System.out.print(i + " ");
        sc.close();
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int leftSize = mid - low + 1, rightSize = high - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
            left[i] = arr[low + i];
        for (int j = 0; j < rightSize; j++)
            right[j] = arr[mid + j + 1];

        int k = low, i = 0, j = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < leftSize)
            arr[k++] = left[i++];
        while (j < rightSize)
            arr[k++] = right[j++];
    }
}