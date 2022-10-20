package Binary_Search;

import java.util.*;
public class SearchInIfiniteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int key = sc.nextInt();

        if(arr[0] == key) {
            System.out.println("0");
            System.exit(0);
        }

        int i = 1;
        while(arr[i] < key) {
            i = i * 2;
            if(arr[i] == key) {
                System.out.println(i);
                System.exit(0);
            }
            else if(arr[i] > key) {
                System.out.println(binarySearch(arr,(i/2) + 1, i - 1, key));
                System.exit(0);
            }

        }
        sc.close();
    }

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if(arr[mid] == key)
            return mid;
        else if(arr[mid] > key)
            return binarySearch(arr,low,mid-1,key);
        else
            return binarySearch(arr,mid+1,high,key);
    }
}

// 5
// 1 2 3 40 50
// 40

// 3