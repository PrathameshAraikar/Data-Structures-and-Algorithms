package Stack;

import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stock = new int[n];

        for (int i = 0; i < n; i++)
            stock[i] = sc.nextInt();

        stockSpan(stock);
        sc.close();
    }

    public static void stockSpan(int[] arr) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        System.out.print("1 ");

        for (int i = 1; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] <= arr[i])
                stk.pop();

            int span = stk.isEmpty() ? i + 1 : i - stk.peek();
            System.out.print(span + " ");
            stk.push(i);
        }
    }
}

// 6
// 18 12 13 14 11 16

// 1 1 2 3 1 5