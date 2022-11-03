package Strings;

import java.util.*;

public class CheckForAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        Map<Character, Integer> hMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
            hMap.put(s1.charAt(i), hMap.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i < s2.length(); i++) {
            if (hMap.containsKey(s2.charAt(i)))
                hMap.put(s2.charAt(i), hMap.get(s2.charAt(i)) - 1);
            else
                hMap.put(s2.charAt(i), hMap.getOrDefault(s2.charAt(i), 0) + 1);

            if (hMap.get(s2.charAt(i)) == 0)
                hMap.remove(s2.charAt(i));
        }

        if (hMap.size() == 0)
            System.out.println("ANAGRAM");
        else
            System.out.println("NOT ANAGRAM");

        sc.close();
    }
}

//silent
//listen

//ANAGRAM