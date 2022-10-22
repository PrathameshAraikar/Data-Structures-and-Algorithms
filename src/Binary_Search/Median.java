package Binary_Search;
// Remember that here we assume that n1 < n2
// Binary Search is performed on n1 that is smaller array.
// Time Complexity O(log(n1))

import java.util.*;

public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();

        System.out.println(median(arr1, arr2, n1, n2));
        sc.close();
    }

    public static double median(int[] a1, int[] a2, int n1, int n2) {
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = ((n1 + n2 + 1) / 2) - mid1;

            int min1 = (mid1 == n1) ? Integer.MAX_VALUE : a1[mid1];
            int max1 = (mid1 == 0) ? Integer.MIN_VALUE : a1[mid1 - 1];
            int min2 = (mid2 == n2) ? Integer.MAX_VALUE : a2[mid2];
            int max2 = (mid2 == 0) ? Integer.MIN_VALUE : a2[mid2 - 1];

            // Check for Median Case
            if ((max1 <= min2) && (max2 <= min1)) {
                if ((n1 + n2) % 2 == 0)
                    return (double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                else
                    return (Math.max(max1, max2));
            }

            // Check for Corner Case
            else if (max1 > min2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }

        return -1;
    }
}

// 5
// 10 20 30 40 50
// 5
// 5 15 25 35 45

// 27.5