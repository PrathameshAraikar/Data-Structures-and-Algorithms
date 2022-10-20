package Binary_Search;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int key = sc.nextInt();
        iterativeBinarySearch(arr, key);
        recursiveBinarySearch(arr, 0, n - 1, key);
        int result = recursiveBinarySearch(arr, 0, n - 1, key);
        System.out.println("Mid Index: " + result + ", Mid Value: " + arr[result]);
        sc.close();
    }

    public static void iterativeBinarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                System.out.println("Mid Index: " + mid + ", Mid Value: " + arr[mid]);
                return;
            } else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
    }

    public static int recursiveBinarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == key)
            return mid;
        else if (arr[mid] > key)
            return recursiveBinarySearch(arr, low, mid - 1, key);
        else
            return recursiveBinarySearch(arr, mid + 1, high, key);
    }
}

// 5
// 10 20 30 40 50
// 30

// Mid Index: 2, Mid Value: 30