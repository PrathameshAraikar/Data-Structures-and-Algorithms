package Arrays;

import java.util.*;

public class LargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largestElementIndex = 0, largestElement = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[largestElementIndex]) {
                largestElementIndex = i;
                largestElement = arr[i];
            }
        }

        System.out.println(largestElement);
        sc.close();
    }
}