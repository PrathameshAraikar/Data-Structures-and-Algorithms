package Hashing;

import java.util.*;

public class LongestSubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int sum = sc.nextInt();

        System.out.println(longestSubarrayWithGivenSum(arr, sum));
        sc.close();
    }

    public static int longestSubarrayWithGivenSum(int[] arr, int givenSum) {
        int preSum = 0, res = 0;
        Map<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            // Case 1
            if (preSum == givenSum)
                res = i + 1;

            // Case 2
            if (!hMap.containsKey(preSum))
                hMap.put(preSum, i);

            // Case 3
            if (hMap.containsKey(preSum - givenSum))
                res = Math.max(res, i - hMap.get(preSum - givenSum));
        }

        return res;
    }
}

//6
//10 5 2 7 1 9
//15

//4