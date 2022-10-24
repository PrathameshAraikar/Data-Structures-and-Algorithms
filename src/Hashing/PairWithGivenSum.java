package Hashing;

import java.util.*;
public class PairWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int sum = sc.nextInt();

        Set<Integer> hSet = new HashSet<>();
        for(int i: arr) {
            if(hSet.contains(sum-i))
                System.out.println((sum-i) + " " + i);
            hSet.add(i);
        }
        sc.close();
    }
}

// 5
// 3 4 2 1 5
// 9

// 4 5