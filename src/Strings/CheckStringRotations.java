package Strings;

import java.util.*;

public class CheckStringRotations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(areRotations(s1, s2));
        sc.close();
    }

    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        return ((s1 + s1).contains(s2));
    }
}

//abab
//abba

//false