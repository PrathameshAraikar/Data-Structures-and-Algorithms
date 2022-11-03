package Strings;

import java.util.*;

public class LongestSubstringWithDistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] previous = new int[256];
        Arrays.fill(previous, -1);

        int start = 0, maxEnd = 0, res = 0;
        for (int end = 0; end < str.length(); end++) {
            start = Math.max(start, previous[str.charAt(end)] + 1);
            maxEnd = end - start + 1;
            res = Math.max(maxEnd, res);
            previous[str.charAt(end)] = end;
        }

        System.out.println(res);
        sc.close();
    }
}

//prathamesh

//6