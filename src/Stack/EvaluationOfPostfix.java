package Stack;

import java.util.*;

public class EvaluationOfPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayDeque<Integer> stk = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // if ch = ' '
            if (ch == ' ')
                continue;

                // if ch is a number
            else if (Character.isDigit(ch)) {
                int n = 0;

                //extract the characters and store it in num
                while (Character.isDigit(ch)) {
                    n = n * 10 + (int) (ch - '0');
                    i++;
                    ch = s.charAt(i);
                }
                i--;

                //push the number in stack
                stk.push(n);
            }

            // if ch is an operator
            else {
                int op2 = stk.peek();
                stk.pop();
                int op1 = stk.peek();
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

// 100 200 + 2 / 5 * 7 +

// 757