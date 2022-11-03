package Strings;

import java.util.*;

public class AnagramSearch {

    static final int CHAR = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();

        int[] countText = new int[CHAR];
        int[] countPattern = new int[CHAR];

        for (int i = 0; i < pattern.length(); i++) {
            countText[text.charAt(i)]++;
            countPattern[pattern.charAt(i)]++;
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (areSame(countText, countPattern)) {
                System.out.println("Anagram Search Found");
                System.exit(0);
            }

            // Sliding the window
            countText[text.charAt(i)]++;
            countText[text.charAt(i - pattern.length())]--;
        }

        System.out.println("Anagram Search NOT Found");
        sc.close();
    }

    public static boolean areSame(int[] ct, int[] cp) {
        for (int i = 0; i < CHAR; i++)
            if (ct[i] != cp[i])
                return false;

        return true;
    }
}

//ababababab
//abba

//Anagram Search Found