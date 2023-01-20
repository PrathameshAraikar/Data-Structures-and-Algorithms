package Queue_Deque;

import java.util.*;
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        ArrayDeque<Integer> deq = new ArrayDeque<>();

        // Processing the first window
        for(int i=0; i<k; i++) {
            while(!deq.isEmpty() && arr[i] >= arr[deq.peek()])
                deq.pollLast();

            deq.offerLast(i);
        }

        // Processing the rest windows
        for(int i=k; i<n; i++) {
            System.out.print(arr[deq.peek()] + " ");

            while(!deq.isEmpty() && deq.peek() <= i-k)
                deq.pollFirst();

            while(!deq.isEmpty() && arr[i] >= arr[deq.peek()])
                deq.pollLast();

            deq.offerLast(i);
        }

        System.out.print(arr[deq.peek()] + " ");
        sc.close();
    }
}

//5
//2 4 3 1 6
//3

//4 4 6