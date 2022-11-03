package Strings;

import java.util.*;

public class PatternSearchingKMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        int[] lps = new int[pattern.length()];
        fillLPSArray(pattern, lps);
        kmpAlgorithm(text, pattern, lps);
        sc.close();
    }

    public static void kmpAlgorithm(String txt, String pat, int[] lps) {
        int n = txt.length();
        int m = pat.length();
        int i = 0, j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern Found at Index: " + (i - j));
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }
    }

    public static void fillLPSArray(String pat, int[] lps) {
        int n = pat.length(), i = 1, len = 0;
        lps[0] = 0;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                    //i++;
                }
            }
        }
    }
}

//ababcababaad
//ababa

//Found Pattern at Index: 5