package Queue_Deque;

import java.util.*;

public class GenerateNumbersWithDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c1 = sc.next().charAt(0);
        char c2 = sc.next().charAt(0);
        int n = sc.nextInt();

        Queue<String> q = new ArrayDeque<>();
        q.offer(String.valueOf(c1));
        q.offer(String.valueOf(c2));
        for (int i = 0; i < n; i++) {
            String curr = q.poll();
            System.out.print(curr + " ");
            q.offer(curr + c1);
            q.offer(curr + c2);
        }

        sc.close();
    }
}