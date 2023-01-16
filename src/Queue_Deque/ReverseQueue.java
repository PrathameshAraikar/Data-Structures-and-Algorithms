package Queue_Deque;

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);

        System.out.println("Before Reversal: " + q);
        q = reverse(q);
        System.out.println("After Reversal: " + q);
    }

    public static Queue<Integer> reverse(Queue<Integer> q) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int top = q.poll();
            stk.push(top);
        }

        while (!stk.isEmpty()) {
            int top = stk.pop();
            q.offer(top);
        }

        return q;
    }
}