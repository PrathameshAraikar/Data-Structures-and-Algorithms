package Arrays;

import java.util.*;

public class MaximumOccuringInGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();

        int[] frequency = new int[1000];
        for (int i = 0; i < n; i++) {
            frequency[a[i]]++;
            frequency[b[i] + 1]--;
        }

        int result = 0;
        for (int i = 1; i < frequency.length; i++) {
            frequency[i] += frequency[i - 1];
            if (frequency[i] > frequency[result])
                result = i;
        }

        System.out.print(result);
        sc.close();
    }
}

// 4
// 1 2 5 15
// 5 8 7 18

// 5