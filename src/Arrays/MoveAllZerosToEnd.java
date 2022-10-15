package Arrays;

import java.util.*;
public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1 0 0 1 1 1 0 0
        int count = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        while (count < n)
            arr[count++] = 0;

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}