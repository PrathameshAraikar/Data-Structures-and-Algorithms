package Stack;

import java.util.*;

public class PreviousGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        stk.push(arr[0]);
        System.out.print("-1 ");

        for (int i = 1; i < n; i++) {
            while (!stk.isEmpty() && stk.peek() <= arr[i])
                stk.pop();

            int previousGreaterElement = stk.isEmpty() ? -1 : stk.peek();
            System.out.print(previousGreaterElement + " ");
            stk.push(arr[i]);
        }
        sc.close();
    }
}

// 5
// 20 30 10 5 15

// -1 -1 30 10 30