package Sorting;

import java.util.*;
public class CountInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Inversions: " + countInversions(arr, 0 , n-1));
        sc.close();
    }

    public static int countInversions(int[] arr, int low, int high) {
        int res = 0;
        if(low < high) {
            int mid = (low + high) / 2;
            res += countInversions(arr, low, mid);
            res += countInversions(arr, mid+1, high);
            res += countAndMerge(arr, low, mid, high);
        }
        return res;
    }

    public static int countAndMerge(int[] arr, int low , int mid, int high) {
        int leftSize = mid - low + 1, rightSize = high - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for(int i=0; i<leftSize; i++)
            left[i] = arr[low + i];
        for(int j=0; j<rightSize; j++)
            right[j] = arr[mid + j + 1];

        int i = 0, j = 0, k = low, res = 0;
        while(i < leftSize && j < rightSize) {
            if(left[i] < right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                res = res + (leftSize - i);
            }
        }

        while (i < leftSize)
            arr[k++] = left[i++];
        while (j < rightSize)
            arr[k++] = right[j++];

        return res;
    }
}