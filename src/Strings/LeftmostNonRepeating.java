package Strings;

import java.util.*;

public class LeftmostNonRepeating {

    static final int CHAR = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] visited = new int[CHAR];

        Arrays.fill(visited, -1);
        for(int i=0; i<str.length(); i++) {
            // To mark the appearance of an element we use its index
            if(visited[str.charAt(i)] == -1)
                visited[str.charAt(i)] = i;

            // If it is not -1 that means the element is already present and it is repeating and
            // to represent the repeating element we use -2
            else
                visited[str.charAt(i)] = -2;
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<CHAR; i++)
            if(visited[i] >= 0)
                res = Math.min(visited[i], res);

        System.out.println("Index of leftmost non-repeating element: " + res);
        sc.close();
    }
}

//geeksforgeeks
//Index of leftmost non-repeating element: 5
