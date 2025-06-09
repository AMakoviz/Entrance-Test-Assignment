package org.example.AEE;

import java.util.Stack;

public class ParsePost {
    private Stack<Double> stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
    }

    public double doParse() {
        stack = new Stack<>();
        String[] tokens = input.trim().split("\\s+");

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    double result;
                    switch (token) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                throw new ArithmeticException("Division by zero");
                            }
                            result = num1 / num2;
                            break;
                        default:
                            result = 0;
                    }
                    stack.push(result);
                    break;
                default:
                    stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }
}
