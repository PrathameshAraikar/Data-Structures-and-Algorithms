package Stack;

import java.util.*;

public class BalancedParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(validParenthesis(s));
        sc.close();
    }

    public static boolean validParenthesis(String s) {
        ArrayDeque<Character> stk = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(' || x == '{' || x == '[')
                stk.push(x);
            else {
                if (stk.isEmpty())
                    return false;
                else if (areSame(stk.peek(), x))
                    stk.pop();
                else
                    return false;
            }
        }

        return stk.isEmpty();
    }

    public static boolean areSame(char a, char b) {
        if (a == '(' && b == ')')
            return true;
        else if (a == '{' && b == '}')
            return true;
        else if (a == '[' && b == ']')
            return true;
        return false;
    }
}