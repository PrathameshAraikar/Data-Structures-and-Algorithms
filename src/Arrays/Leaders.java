package Arrays;

import java.util.*;

public class Leaders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int currentLeader = arr[n-1];
        for(int i = n-2; i>=0; i--) {
            if(currentLeader < arr[i])
                currentLeader = arr[i];
        }

        System.out.print(currentLeader);
        sc.close();
    }
}