package Hashing;

import java.util.*;

public class CountFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i : arr)
            hMap.put(i, hMap.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> itr : hMap.entrySet())
            System.out.print(itr.getKey() + " " + itr.getValue() + "\n");

        sc.close();
    }
}

// 10
// 1 2 2 2 3 4 3 4 3 1

// 1 2
// 2 3
// 3 3
// 4 2