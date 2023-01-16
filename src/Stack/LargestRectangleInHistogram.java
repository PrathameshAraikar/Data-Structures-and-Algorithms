package Stack;

import java.util.*;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++)
            heights[i] = sc.nextInt();

        int largestRectangularAreaInHistogram = largestAreaInHistogram(heights);
        System.out.println("Largest Rectangular Area in Histogram: " + largestRectangularAreaInHistogram);
        sc.close();
    }

    public static int largestAreaInHistogram(int[] arr) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int res = 0, curr = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                int top = stk.peek();
                stk.pop();
                curr = arr[top] * (stk.isEmpty() ? i : i - stk.peek() - 1);
                res = Math.max(curr, res);
            }
            stk.push(i);
        }

        // Remaining elements present in the Stack
        while (!stk.isEmpty()) {
            int top = stk.peek();
            stk.pop();
            curr = arr[top] * (stk.isEmpty() ? arr.length : arr.length - stk.peek() - 1);
            res = Math.max(curr, res);
        }

        return res;
    }
}

// 7
// 6 2 5 4 1 5 6

// 10