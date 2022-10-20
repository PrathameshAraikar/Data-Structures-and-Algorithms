package Arrays;

import java.util.*;

public class MinimumConsecutiveFlips {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0])
                    System.out.print("From " + i + " to ");
                else
                    System.out.print(i - 1 + "\n");
            }
        }

        if (arr[n - 1] != arr[0])
            System.out.print(n - 1 + "\n");
        sc.close();
    }
}

// 16
// 0 0 1 1 0 0 1 1 0 1 1 1 1 1 0 1

//From 2 to 3
//From 6 to 7
//From 9 to 13
//From 15 to 15