package Binary_Search;

import java.util.*;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                System.out.println(mid);
                System.exit(0);
            } else if (mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        sc.close();
    }
}

//7
//5 20 40 30 20 50 60

// 2