package Queue_Deque;

import java.util.*;

public class QueueUsingStack {
    private static ArrayDeque<Integer> mainStack = new ArrayDeque<>();
    private static ArrayDeque<Integer> auxStack = new ArrayDeque<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println("Top: " + top());
        pop();
        System.out.println("Top: " + top());
        pop();
        System.out.println("Top: " + top());

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println("Queue Top: " + q.poll());
        System.out.println("Queue Top: " + q.poll());
        System.out.println("Queue Top: " + q.poll());
    }

    public static void push(int x) {
        while (!mainStack.isEmpty()) {
            int top = mainStack.peek();
            mainStack.pop();
            auxStack.push(top);
        }

        mainStack.push(x);

        while (!auxStack.isEmpty()) {
            int top = auxStack.peek();
            auxStack.pop();
            mainStack.push(top);
        }
    }

    public static void pop() {
        mainStack.pop();
        return;
    }

    public static int top() {
        return mainStack.peek() == null ? -1 : mainStack.peek();
    }

    public static boolean isEmpty() {
        return mainStack.isEmpty();
    }
}
