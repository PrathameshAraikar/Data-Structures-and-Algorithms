package Stack;

import java.util.*;
public class StackWithGetMin {
    public static void main(String[] args) {
        StackWithGetMinInO1SpaceTime s = new StackWithGetMinInO1SpaceTime();
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.print("Minimum Element from Stack: " + s.getMin() );
    }
}

class StackWithGetMinInO1SpaceTime {
    ArrayDeque<Integer> stk = new ArrayDeque<>();
    int min = 0;

    public void push(int x) {
        if(stk.isEmpty()) {
            min = x;
            stk.push(x);
        } else if (x <= min) {
            stk.push(2*x - min);
            min = x;
        } else {
            stk.push(x);
        }
    }

    public void pop() {
        int top = stk.peek(); stk.pop();
        if(top <= min)
            min = 2*min - top;
    }

    public int peek() {
        return (stk.peek() <= min ? min : stk.peek());
    }

    public int getMin() {
        return min;
    }
}
