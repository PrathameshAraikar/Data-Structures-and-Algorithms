package Arrays;
// Sliding Window

import java.util.*;

public class MaximumSumOfKConsecutive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Calculate sum for FIRST WINDOW
        int currentSum = 0;
        for(int i=0; i<k; i++) {
            currentSum += arr[i];
        }

        // Calculate sum for OTHER WINDOWS
        int maxSum = currentSum;
        for(int i=k; i<n; i++) {
            currentSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.print(maxSum);
        sc.close();
    }
}

// 6
// 3
// 1 8 30 -5 20 7

// 45