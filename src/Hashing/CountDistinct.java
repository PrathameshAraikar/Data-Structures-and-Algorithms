package Hashing;

import java.util.*;

public class CountDistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Set<Integer> hSet = new HashSet<>();
        for (int i : arr)
            hSet.add(i);

        System.out.println(hSet.size());
        sc.close();
    }
}

// 10
// 2 4 4 3 1 3 5 6 8 2

// 7