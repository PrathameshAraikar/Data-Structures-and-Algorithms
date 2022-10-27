package Hashing;

import java.util.*;

public class LongestCommonSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++)
            arr2[i] = sc.nextInt();

        int[] diff = new int[n];
        for (int i = 0; i < n; i++)
            diff[i] = arr1[i] - arr2[i];

        System.out.println(longestSubarray(diff));
        sc.close();
    }

    public static int longestSubarray(int[] arr) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int preSum = 0, res = 0;

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            // case 1
            if (preSum == 0)
                res = i + 1;

            // case 2
            if (!hMap.containsKey(preSum))
                hMap.put(preSum, i);

                // case 3
            else
                res = Math.max(res, i - hMap.get(preSum));

        }

        return res;
    }
}

//7
//0 1 0 1 1 1 1
//1 1 1 1 1 0 1

//6