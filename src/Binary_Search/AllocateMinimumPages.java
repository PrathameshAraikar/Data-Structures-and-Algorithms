package Binary_Search;

import java.util.*;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        int max = 0, sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }

        int low = max, high = sum, res = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(isFeasible(arr, n, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(res);
        sc.close();
    }

    public static boolean isFeasible(int[] arr, int n, int k, int requiredSum) {
        int students = 1, sum = 0;
        for(int i=0; i<n; i++) {
            if(sum + arr[i] > requiredSum) {
                students++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return (students <= k);
    }
}

// 4
// 10 20 10 30
// 2

// 40
