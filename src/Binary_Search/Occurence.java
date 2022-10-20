package Binary_Search;

import java.util.*;

public class Occurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int key = sc.nextInt();
        System.out.println("First Occurence: " + firstOccurence(arr, n, key));
        System.out.println("Last Occurence: " + lastOccurence(arr, n, key));
        System.out.println("Count: " + countOccurences(arr, n, key));
        sc.close();
    }

    public static int firstOccurence(int[] arr, int n, int key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key)
                high = mid - 1;
            else if (arr[mid] < key)
                low = mid + 1;
            else {
                if (arr[mid] == 0 || arr[mid] != arr[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    public static int lastOccurence(int[] arr, int n, int key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key)
                low = mid + 1;
            else if (arr[mid] > key)
                high = mid - 1;
            else {
                if (arr[mid] == n - 1 || arr[mid] != arr[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }
        }

        return -1;
    }

    public static int countOccurences(int[] arr, int n, int key) {
        return lastOccurence(arr, n, key) - firstOccurence(arr, n, key) + 1;
    }
}

// 10
// 1 2 2 3 3 3 4 4 5 6
// 3

// First Occurence: 3
// Last Occurence:  5
// Count: 3