package Arrays;

import java.util.*;

public class StockBuyAndSell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }

        System.out.print(profit);
        sc.close();
    }
}

// 5
// 1 5 3 8 12

// 13