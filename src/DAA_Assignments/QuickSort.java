package DAA_Assignments;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = generateRandomArrayOfSizeN(n);
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();
        quickSort(arr, 0, n - 1);

        for (int i : arr)
            System.out.print(i + " ");

        sc.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = hoarePartion(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int hoarePartion(int[] arr, int low, int high) {
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

    public static int[] generateRandomArrayOfSizeN(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }
}