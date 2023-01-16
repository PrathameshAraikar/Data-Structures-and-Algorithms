package Stack;

import java.util.*;

public class NextGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        stk.push(arr[n - 1]);
        deq.push(-1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i])
                stk.pop();

            int nextGreaterElement = stk.isEmpty() ? -1 : stk.peek();
            deq.push(nextGreaterElement);
            stk.push(arr[i]);
        }
        sc.close();

        System.out.print(deq);
    }
}

// 8
// 5 15 10 8 6 12 9 18

// 15 18 12 12 12 18 18 -1