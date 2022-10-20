package Arrays;

import java.util.*;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int low = 0, high = n - 1;
        while (low < high) {
            arr[low] = arr[low] ^ arr[high];
            arr[high] = arr[low] ^ arr[high];
            arr[low] = arr[low] ^ arr[high];
            low++;
            high--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}