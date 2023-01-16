package Stack;

import java.util.*;

public class KStacksInOneArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KStacks ks = new KStacks(2, 5);
        ks.push(0, 1);
        ks.push(0, 2);
        ks.push(0, 3);
        ks.push(1, 4);
        ks.push(1, 5);
        System.out.println(ks.pop(0));
        System.out.println(ks.pop(1));
        sc.close();
    }
}

class KStacks {
    int k, cap, freeTop = 0;
    int[] arr, top, next;

    KStacks(int k, int size) {
        this.k = k;
        cap = size;
        arr = new int[size];
        next = new int[size];
        top = new int[k];

        for (int i = 0; i < k; i++)
            top[i] = -1;

        for (int i = 0; i < cap - 1; i++)
            next[i] = i + 1;
        next[cap - 1] = -1;
    }

    public void push(int sn, int x) {
        int i = freeTop;
        freeTop = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = x;
    }

    public int pop(int sn) {
        int i = top[sn];
        top[sn] = next[i];
        next[i] = freeTop;
        freeTop = i;
        return arr[i];
    }
}