package Arrays;

import java.util.*;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int counter = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                counter++;
                res = Math.max(res, counter);
            } else counter = 0;
        }

        System.out.print(res);
        sc.close();
    }
}

// 5
// 1 0 1 1 0

// 2