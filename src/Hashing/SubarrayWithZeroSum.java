package Hashing;

import java.util.*;

public class SubarrayWithZeroSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(subarrayWithZeroSum(arr));
        sc.close();
    }

    public static boolean subarrayWithZeroSum(int[] arr) {
        Set<Integer> hSet = new HashSet<>();
        int preSum = 0;
        for (int i : arr) {
            preSum += i;

            // First Case
            if (preSum == 0)
                return true;

            // Second Case
            if (hSet.contains(preSum))
                return true;

            hSet.add(preSum);
        }

        return false;
    }
}

// 7
// 5 3 9 -4 -6 7 -1

// true