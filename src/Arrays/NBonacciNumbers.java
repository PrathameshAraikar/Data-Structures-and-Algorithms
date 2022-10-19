package Arrays;

import java.util.*;

public class NBonacciNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int windowSize = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        Arrays.fill(arr, 0);
        arr[windowSize] = 1;
        arr[windowSize - 1] = 1;

        for (int i = windowSize + 1; i < n; i++) {
            arr[i] = 2 * arr[i - 1] - arr[i - windowSize - 1];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}

// 3
// 8

// 0, 0, 1, 1, 2, 4, 7, 13