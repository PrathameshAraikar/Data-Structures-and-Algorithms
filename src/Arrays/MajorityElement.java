package Arrays;
// Moore's Voting Algorithm

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Check for a CANDIDATE
        int result = 0, count = 1;
        for (int i = 0; i < n; i++) {
            if (arr[result] == arr[i])
                count++;
            else count--;

            if (count == 0) {
                result = i;
                count = 1;
            }
        }

        // Check whether the CANDIDATE is a MAJORITY
        count = 0;
        for (int i = 0; i < n; i++)
            if (arr[result] == arr[i])
                count++;

        if (count <= n / 2)
            result = -1;

        System.out.print(arr[result]);
        sc.close();
    }
}

// 7
// 8 8 6 6 6 4 6

// 6