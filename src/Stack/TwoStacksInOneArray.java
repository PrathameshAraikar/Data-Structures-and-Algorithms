package Stack;

import java.util.*;

public class TwoStacksInOneArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoStacks ts = new TwoStacks(5);
        ts.push1(1);
        ts.push1(2);
        ts.push1(3);
        ts.push2(4);
        ts.push2(5);
        System.out.println(ts.pop1());
        System.out.println(ts.pop1());
        System.out.println(ts.pop2());
        sc.close();
    }
}

class TwoStacks {
    int n, top1, top2;
    int[] arr;

    TwoStacks(int size) {
        n = size;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        }
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }

        return -1;
    }

    public int pop2() {
        if (top2 < n) {
            int x = arr[top2];
            top2++;
            return x;
        }

        return -1;
    }
}