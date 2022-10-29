package Hashing;

import java.util.*;

public class LongestSubarrayWithEqualZeroOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr[i] = (arr[i] == 0) ? -1 : 1;

        System.out.println("Length of Longest Subarray with equal 0s and 1s: " + lengthOfLongestSubarrayWithEqualZeroOnes(arr));
        indexOfLongestSubarrayWithEqualZeroOnes(arr);
        sc.close();
    }

    public static int lengthOfLongestSubarrayWithEqualZeroOnes(int[] arr) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int preSum = 0, result = 0;

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            // case 1
            if (preSum == 0)
                result = i + 1;

            // case 2
            if (!hMap.containsKey(preSum))
                hMap.put(preSum, i);

            // case 3
            if (hMap.containsKey(preSum))
                result = Math.max(result, i - hMap.get(preSum));
        }

        return result;
    }

    // A little sceptical
    public static void indexOfLongestSubarrayWithEqualZeroOnes(int[] arr) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int preSum = 0, result = 0, endingIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            // case 1
            if (preSum == 0) {
                result = i + 1;
                endingIndex = i;
            }

            // case 2
            if (!hMap.containsKey(preSum))
                hMap.put(preSum, i);

            // case 3
            if (hMap.containsKey(preSum)) {
                result = Math.max(result, i - hMap.get(preSum));
                endingIndex = i;
            }
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] == -1) ? 0 : 1;

        int startingIndex = endingIndex - result;
        System.out.println("Index of Longest Subarray " + startingIndex + " to " + (endingIndex - 1));
    }
}

//9
//1 1 1 0 1 0 1 1 1

//4