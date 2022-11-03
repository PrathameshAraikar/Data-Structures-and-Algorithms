package Strings;

import java.util.*;

public class CheckForSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j))
                j++;
            i++;
        }

        System.out.println(j == s2.length());
        sc.close();
    }
}

//Prathamesh
//tame

//true