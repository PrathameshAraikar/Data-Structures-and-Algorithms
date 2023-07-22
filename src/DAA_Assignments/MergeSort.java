package DAA_Assignments;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = generateRandomArrayOfSizeN(n);
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();
        mergeSort(arr, 0, n - 1);

        for (int i : arr)
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
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        for (int i = 0; i < mid - low + 1; i++)
            left[i] = arr[low + i];

        for (int j = 0; j < high - mid; j++)
            right[j] = arr[mid + j + 1];

        int i = 0, j = 0, k = low;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static int[] generateRandomArrayOfSizeN(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }
}