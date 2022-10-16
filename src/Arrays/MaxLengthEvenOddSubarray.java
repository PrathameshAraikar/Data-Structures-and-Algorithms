package Arrays;

import java.util.*;
public class MaxLengthEvenOddSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int current = 0, result = 0;
        for(int i=1; i<n; i++) {
            if ((arr[i] % 2 == 0) && (arr[i-1] % 2 != 0) || (arr[i] % 2 != 0) && (arr[i-1]) % 2 == 0) {
                current++;
                result = Math.max(current, result);
            } else current = 0;
        }

        System.out.print(result);
        sc.close();
    }
}

// 10
// 1 3 2 4 6 3 4 3 2 2

// 4