package Stack;

import java.util.*;

public class InfixToPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayDeque<Character> stk = new ArrayDeque<>();
        StringBuilder prefix = new StringBuilder("");
        StringBuilder infix = new StringBuilder(s);
        infix.reverse();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // if ch = ')'
            if (ch == ')')
                stk.push(ch);

                // if ch is an operand
            else if (Character.isLetterOrDigit(ch))
                prefix.append(ch);

                // if ch is a '('
            else if (ch == '(') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    char top = stk.peek();
                    stk.pop();
                    prefix.append(top);
                }
                stk.pop();
            }

            // if ch is an operator
            else {
                while (!stk.isEmpty() && precedence(ch) <= precedence(stk.peek())) {
                    char top = stk.peek();
                    stk.pop();
                    prefix.append(top);
                }
                stk.push(ch);
            }
        }

        while (!stk.isEmpty()) {
            char top = stk.peek();
            stk.pop();
            prefix.append(top);
        }

        System.out.println("Prefix: " + prefix.reverse());
        sc.close();
    }

    public static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;

            case '*':
            case '/':
                return 2;

            case '+':
            case '-':
                return 1;
        }
        return -1;
    }
}

// a+b*c

// Prefix: +a*bc