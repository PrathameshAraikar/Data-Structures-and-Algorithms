package Hashing;

import java.util.*;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Set<Integer> hSet = new HashSet<>();
        for (int i : arr)
            hSet.add(i);

        int res = 0;
        for (int i : arr) {
            if (!hSet.contains(i - 1)) {
                int curr = 1;
                while (hSet.contains(i + curr)) {
                    curr++;
                    res = Math.max(res, curr);
                }
            }
        }

        System.out.println(res);
        sc.close();
    }
}

//6
//10 1 20 2 3 4

//4