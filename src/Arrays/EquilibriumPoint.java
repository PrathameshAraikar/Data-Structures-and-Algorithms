package Arrays;

import java.util.*;

public class EquilibriumPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int rightSum = 0;
        for (int i = 0; i < n; i++)
            rightSum += arr[i];

        int leftSum = 0, result = 0;
        for (int i = 0; i < n; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum)
                result = arr[i];
            leftSum += arr[i];
        }

        System.out.print(result);
        sc.close();
    }
}

// 6
// 3 4 8 -9 20 6