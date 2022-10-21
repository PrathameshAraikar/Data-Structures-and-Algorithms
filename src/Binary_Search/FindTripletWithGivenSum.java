package Binary_Search;

import java.util.*;

public class FindTripletWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int sum = sc.nextInt();

        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            if (pairExists(arr, i + 1, n - 1, sum - arr[i])) {
                System.out.println("TRIPLET EXISTS");
                System.exit(0);
            }
        }

        System.out.println("TRIPLET DOES NOT EXIST");
        sc.close();
    }

    public static boolean pairExists(int[] arr, int left, int right, int sum) {
        while (left <= right) {
            if (arr[left] + arr[right] == sum)
                return true;
            else if (arr[left] + arr[right] > sum)
                right--;
            else
                left++;
        }

        return false;
    }
}

// 6
// 1 4 45 6 10 8
// 22

// TRIPLET EXISTS