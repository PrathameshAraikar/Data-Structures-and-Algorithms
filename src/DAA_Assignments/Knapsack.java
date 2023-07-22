package DAA_Assignments;

public class Knapsack {
    public static void main(String[] args) {
        // Initialize the weight and value arrays
        int[] wt = {1, 2, 5, 6, 7};
        int[] val = {1, 6, 18, 22, 24};
        int W = 11; // Set the maximum weight capacity of the knapsack
        knapsack(W, wt, val);
    }

    public static void knapsack(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
                }
            }
        }

        printDPMatrix(dp);
        System.out.println();
        printSelectedItems(dp, wt, W);
    }

    public static void printDPMatrix(int[][] dp) {
        for (int[] i : dp) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printSelectedItems(int[][] dp, int[] wt, int W) {
        int[] selected = new int[wt.length];
        int i = wt.length, j = W;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selected[i - 1] = 1;
                j -= wt[i - 1];
            }
            i--;
        }

        for (int k : selected)
            System.out.print(k + " ");
    }
}