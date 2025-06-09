package org.example.AEE;

import java.util.Stack;

public class InToPost {
    private Stack<Character> stack;
    private String input;
    private String output = "";

    public InToPost(String input) {
        this.input = input;
        stack = new Stack<>();
    }

    public String doTrans() {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isDigit(ch) || ch == '.' || (ch == '-' && (i == 0 || input.charAt(i - 1) == '('))) {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    output += number + " ";
                    number.setLength(0);
                }

                switch (ch) {
                    case '+':
                    case '-':
                        gotOper(ch, 1);
                        break;
                    case '*':
                    case '/':
                        gotOper(ch, 2);
                        break;
                    case '(':
                        stack.push(ch);
                        break;
                    case ')':
                        gotParen(ch);
                        break;
                    case ' ':
                        break; // ignore spaces
                    default:
                        throw new IllegalArgumentException("Unexpected character: " + ch);
                }
            }
        }

        if (number.length() > 0) {
            output += number + " ";
        }

        while (!stack.isEmpty()) {
            output += stack.pop() + " ";
        }

        return output.trim();
    }

    private void gotOper(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.peek();
            if (opTop == '(') {
                break;
            } else {
                int prec2 = (opTop == '+' || opTop == '-') ? 1 : 2;
                if (prec2 < prec1) {
                    break;
                } else {
                    output += stack.pop() + " ";
                }
            }
        }
        stack.push(opThis);
    }

    private void gotParen(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx + " ";
            }
        }
    }
}
