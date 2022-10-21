package Binary_Search;

import java.util.*;

public class SearchInSortedRotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int key = sc.nextInt();

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                System.out.println(mid);
                System.exit(0);
            } else if (arr[low] < arr[mid]) {
                // LHS is sorted
                if (key >= arr[low] && key <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // RHS is sorted
                if (key >= arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        sc.close();
    }
}

//6
//10 20 40 60 5 8
//5

// 4