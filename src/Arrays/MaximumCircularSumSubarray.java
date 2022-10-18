package Arrays;

import java.util.*;

public class MaximumCircularSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxNormal = normalSum(arr, n);
        if (maxNormal < 0) {
            System.out.println(maxNormal);
            System.exit(0);
        }

        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            arr[i] = -arr[i];
        }

        int circularSum = currentSum + normalSum(arr, n);
        System.out.print(Math.max(maxNormal, circularSum));

        sc.close();
    }

    public static int normalSum(int[] arr, int n) {
        int maxEnding = arr[0], result = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            result = Math.max(result, maxEnding);
        }

        return result;
    }
}

// 5
// 8 -4 3 -4 4

// 12