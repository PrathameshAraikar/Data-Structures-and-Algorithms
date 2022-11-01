package Strings;

import java.util.*;

public class AnagramSearch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();

        Map<Character, Integer> textMap = new HashMap<>();
        Map<Character, Integer> patMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            textMap.put(text.charAt(i), textMap.getOrDefault(text.charAt(i), 0) + 1);
            patMap.put(pattern.charAt(i), patMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (textMap.equals(patMap)) {
                System.out.println("Anagram Search Found");
                System.exit(0);
            }

            textMap.put(text.charAt(i), textMap.getOrDefault(text.charAt(i), 0) + 1);
            textMap.put(text.charAt(i - pattern.length()), textMap.get(text.charAt(i - pattern.length())) - 1);

            if (textMap.get(text.charAt(i - pattern.length())) == 0)
                textMap.remove(text.charAt(i - pattern.length()));
        }

        System.out.println("Anagram Search NOT Found");
        sc.close();
    }
}

//ababababab
//abba

//Anagram Search Found