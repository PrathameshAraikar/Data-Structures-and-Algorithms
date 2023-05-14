package Sorting;

import java.util.*;
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i=0; i<n1; i++)
            arr1[i] = sc.nextInt();
        for(int i=0; i<n2; i++)
            arr2[i] = sc.nextInt();

        int[] temp = new int[n1 + n2];
        int k = 0, i = 0, j = 0;
        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j])
                temp[k++] = arr1[i++];
            else
                temp[k++] = arr2[j++];
        }

        System.out.print("Sorted Array: ");
        for(int l: temp)
            System.out.print(l + " ");
        sc.close();
    }
}