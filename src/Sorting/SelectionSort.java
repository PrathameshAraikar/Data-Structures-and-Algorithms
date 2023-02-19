package Sorting;

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        selection(arr, n);
        for (int x : arr)
            System.out.print(x + " ");
        sc.close();
    }

    public static void selection(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min_ind = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_ind]) {
                    min_ind = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;
        }
    }
}