package Hashing;

import java.util.*;

public class MoreThanNByKOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        Map<Integer, Integer> hMap = new HashMap<>();
        for(int i: arr)
            hMap.put(i, hMap.getOrDefault(i, 0) + 1);

        for(Map.Entry<Integer, Integer> i: hMap.entrySet()) {
            if(i.getValue() > n/k)
                System.out.print(i.getKey() + " ");
        }

        sc.close();
    }
}

//7
//1 1 2 3 2 1 1
//2

//1