package Strings;

import java.util.*;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cArr = str.toCharArray();

        int start = 0;
        for(int end=0; end<cArr.length; end++) {
            if(cArr[end] == ' ') {
                reverse(cArr, start, end - 1);
                start = end + 1;
            }
        }

        // Explicitly reverse the last word
        reverse(cArr, start, cArr.length - 1);

        // Reverse the entire String
        reverse(cArr, 0, cArr.length - 1);

        String res = new String(cArr);
        System.out.println(res);
        sc.close();
    }

    public static void reverse(char[] str, int low, int high) {
        while(low < high) {
            str[low] ^= str[high];
            str[high] ^= str[low];
            str[low] ^= str[high];
            low ++; high --;
        }
    }
}

//My name is Prathamesh

//Prathamesh is name My