package Stack;

import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();

        StringBuilder postfix = new StringBuilder();
        ArrayDeque<Character> stk = new ArrayDeque<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If ch is = '(':
            if (ch == '(')
                stk.push(ch);

                // If ch is a letter or a digit:
            else if (Character.isLetterOrDigit(ch))
                postfix.append(ch);

                // If ch is = ')'
            else if (ch == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    char top = stk.peek();
                    stk.pop();
                    postfix.append(top);
                }

                stk.pop();
            }

            // If ch is an operator
            else {
                while (!stk.isEmpty() && precedence(ch) <= precedence(stk.peek())) {
                    char top = stk.peek();
                    stk.pop();
                    postfix.append(top);
                }

                stk.push(ch);
            }
        }

        while (!stk.isEmpty()) {
            char top = stk.peek();
            stk.pop();
            if (top == '(') {
                System.out.println("Invalid expression");
                System.exit(0);
            }

            postfix.append(top);
        }

        System.out.println("Postfix: " + postfix);

        sc.close();
    }

    public static int precedence(char operator) {
        switch (operator) {
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