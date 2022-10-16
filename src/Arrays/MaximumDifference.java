package Arrays;

import java.util.*;

public class MaximumDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int currentMax = arr[0], minVal = arr[0];
        for (int j = 1; j < n; j++) {
            currentMax = Math.max(currentMax, arr[j] - minVal);
            minVal = Math.min(minVal, arr[j]);
        }

        System.out.print(currentMax);
        sc.close();
    }
}

// 7
// 2 3 10 6 4 8 1

// 8