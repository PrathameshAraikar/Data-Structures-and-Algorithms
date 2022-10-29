package Strings;

import java.util.*;

public class LeftmostRepeating {

    static final int CHAR = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean[] visited = new boolean[CHAR];

        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!visited[str.charAt(i)])
                visited[str.charAt(i)] = true;
            else
                res = i;
        }

        System.out.println("Index of leftmost repeating character: " + res);
        sc.close();
    }
}

//geeksforgeeks
//Index of leftmost repeating character: 0
