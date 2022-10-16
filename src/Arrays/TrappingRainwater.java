package Arrays;

import java.util.*;

public class TrappingRainwater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] lMax = new int[n];
        lMax[0] = arr[0];
        for (int i = 1; i < n; i++)
            lMax[i] = Math.max(lMax[i - 1], arr[i]);

        int[] rMax = new int[n];
        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rMax[i] = Math.max(arr[i], rMax[i + 1]);

        int waterStored = 0;
        for (int i = 1; i < n - 1; i++)
            waterStored += Math.min(lMax[i], rMax[i]) - arr[i];

        System.out.print(waterStored);
        sc.close();
    }
}

// 5
// 5 0 6 2 3

// 6