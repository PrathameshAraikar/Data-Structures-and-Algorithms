package Binary_Search;

import java.util.*;

public class FindPairWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int sum = sc.nextInt();
        System.out.print(findPair(arr, sum));
        sc.close();
    }

    public static boolean findPair(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
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

// 5
// 2 5 8 12 30
// 17

// true