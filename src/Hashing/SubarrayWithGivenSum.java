package Hashing;

import java.util.*;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int sum = sc.nextInt();

        System.out.println(subarrayWithGivenSum(arr, sum));
        sc.close();
    }

    public static boolean subarrayWithGivenSum(int[] arr, int givenSum) {
        int preSum = 0;
        Set<Integer> hSet = new HashSet<>();

        for (int i : arr) {
            preSum += i;

            // First Case
            if (preSum == givenSum)
                return true;

            // Second case
            if (hSet.contains(preSum - givenSum))
                return true;

            hSet.add(i);
        }

        return false;
    }
}

//6
//5 8 6 13 3 -1
//22

//true