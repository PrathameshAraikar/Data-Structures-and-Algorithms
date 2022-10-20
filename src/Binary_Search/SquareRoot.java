package Binary_Search;

import java.util.*;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        int low = 1, high = key, sqrt = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midSquare = mid * mid;

            if (midSquare == key) {
                System.out.println(mid);
                System.exit(0);
            } else if (midSquare > key)
                high = mid - 1;
            else {
                low = mid + 1;
                sqrt = mid;
            }
        }
        System.out.println(sqrt);
        sc.close();
    }
}

// 10
// 3