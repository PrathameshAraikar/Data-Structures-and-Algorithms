package Hashing;

import java.util.*;

public class CountDistinctInEveryWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < k; i++)
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);

        System.out.print(hMap.size() + " ");

        for (int i = k; i < n; i++) {
            // Subtract frequency of i-k
            hMap.put(arr[i - k], hMap.get(arr[i - k]) - 1);

            // If frequency of i-k = 0 then remove it
            if (hMap.get(arr[i - k]) == 0)
                hMap.remove(arr[i - k]);

            // Add the rest
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
            System.out.print(hMap.size() + " ");
        }
        sc.close();
    }
}

//6
//10 10 5 3 20 5
//4

//3 4 3