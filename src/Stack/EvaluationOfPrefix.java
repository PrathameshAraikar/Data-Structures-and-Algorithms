package Stack;

import java.util.*;

public class EvaluationOfPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayDeque<Integer> stk = new ArrayDeque<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // if ch = ' '
            if (ch == ' ')
                continue;

                // if ch is a number
            else if (Character.isDigit(ch)) {
                StringBuilder num = new StringBuilder();
                int n = 0;

                //extract the characters and store it in num
                while (Character.isDigit(ch)) {
                    n = n * 10 + (int) (ch - '0');
                    i--;
                    ch = s.charAt(i);
                }
                i++;

                //push the number in stack
                num.append(n);
                num.reverse();
                String number = new String(num);
                n = Integer.parseInt(number);
                stk.push(n);
            }

            // if ch is an operator
            else {
                int op1 = stk.peek();
                stk.pop();
                int op2 = stk.peek();
                stk.pop();

                switch (ch) {
                    case '^':
                        stk.push(op1 ^ op2);
                        break;
                    case '*':
                        stk.push(op1 * op2);
                        break;
                    case '/':
                        stk.push(op1 / op2);
                        break;
                    case '+':
                        stk.push(op1 + op2);
                        break;
                    case '-':
                        stk.push(op1 - op2);
                        break;
                }
            }
        }

        System.out.print(stk.peek());
        sc.close();
    }
}