package Hashing;

import java.util.*;

public class UnionOfArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();

        Set<Integer> hSet = new HashSet<>();
        for (int i : arr1)
            hSet.add(i);

        for (int i : arr2)
            hSet.add(i);

        for (int i : hSet)
            System.out.print(i + " ");

        sc.close();
    }
}

// 5
// 1 2 3 4 5
// 7
// 3 4 5 6 7 8 9

// 1 2 3 4 5 6 7 8 9