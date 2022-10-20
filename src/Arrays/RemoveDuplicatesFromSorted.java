package Arrays;

import java.util.*;

public class RemoveDuplicatesFromSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 10 10 20 20 20 30 30
        int result = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[result - 1]) {
                arr[result] = arr[i];
                result++;
            }
        }

        for (int i = 0; i < result; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}