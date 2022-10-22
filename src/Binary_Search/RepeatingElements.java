package Binary_Search;

import java.util.*;
public class RepeatingElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(repeatingElement(arr));
        sc.close();
    }

    public static int repeatingElement(int[] arr) {
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);

        slow = arr[0];
        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}

// 8
// 1 3 2 4 6 5 7 3

// 3