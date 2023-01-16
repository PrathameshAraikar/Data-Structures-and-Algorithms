package Stack;

import java.util.*;

public class MaximalRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Maximal Rectangle: " + laregstRectangleWithMax1s(matrix, rows, cols));
        sc.close();
    }

    public static int laregstRectangleWithMax1s(int[][] arr, int r, int c) {

        // Calculating maximal rectangle for first row
        int res = largestRectangularAreaInHistogram(arr[0]);

        // For rest rows
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Considering this row as BASE
                if (arr[i][j] == 1)
                    arr[i][j] += arr[i - 1][j];
            }
            res = Math.max(res, largestRectangularAreaInHistogram(arr[i]));
        }

        return res;
    }

    public static int largestRectangularAreaInHistogram(int[] arr) {
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

// 4
// 4

// 0 1 1 0
// 1 1 1 1
// 1 1 1 1
// 1 1 0 0

// 8