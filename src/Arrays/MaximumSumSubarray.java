package Arrays;
// Kadane's Algorithm

import java.util.*;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxEnding = arr[0];
        for (int i = 1; i < n; i++)
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);

        System.out.print(maxEnding);
        sc.close();
    }
}

// 5
// 1 -2 3 -1 2

// 4