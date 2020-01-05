package com.github.hcsp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;


public class Calculator {
    // 请实现一个简单的计算器，能够计算传入的字符串所代表的表达式的值。
    // 表达式只包含数字、+、-、(、)
    // 你可以假设它一定是一个合法的表达式，且不包含负数
    // 例如，传入字符串"1+1"，返回2
    // 传入字符串"(1+2)-(3-7)+(10-12)"，返回5
    public static void main(String[] args) {
        // s1 = 6
//        String s1 = "1+2+ 3";
        // s2 = 567
        String s2 = "(561+2)-(3-7)";
        int value = calculate(s2);
//        System.out.println(calculate(s1));
        System.out.println(value);

    }
//    public static int calculate(String str) {
//        Queue<Character> q = new ArrayDeque<>();
//        for (char c : str.toCharArray()) {
//            if (c != ' ') {
//                q.offer(c);
//            }
//        }
//        q.offer(' ');
//        return cal(q);
//    }

    public static int evaluateExpr(Deque<Object> stack) {

        int res = 0;

        if (!stack.isEmpty()) {
            res = (int) stack.pop();
        }

        // Evaluate the expression till we get corresponding ')'
        while (!stack.isEmpty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    public static int calculate(String s) {

        int operand = 0;
        int n = 0;
        Deque<Object> stack = new ArrayDeque<>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                // Forming the operand - in reverse order.
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (n != 0) {

                    // Save the operand on the stack
                    // As we encounter some non-digit.
                    stack.push(operand);
                    n = 0;
                    operand = 0;

                }
                if (ch == '(') {

                    int res = evaluateExpr(stack);
                    stack.pop();

                    // Append the evaluated result to the stack.
                    // This result could be of a sub-expression within the parenthesis.
                    stack.push(res);

                } else {
                    // For other non-digits just push onto the stack.
                    stack.push(ch);
                }
            }
        }

        //Push the last operand to stack, if any.
        if (n != 0) {
            stack.push(operand);
        }

        // Evaluate any left overs in the stack.
        return evaluateExpr(stack);
    }

//    private static int cal(Queue<Character> q) {
//        int number = 0;
//        int prev = 0;
//        int sum = 0;
//        char prevOp = '+';
//
//        while (!q.isEmpty()) {
//            char c = q.poll();
//            if (c >= '0' && c <= '9') {
//                number = number * 10 + (c - '0');
//            } else if (c == '(') {
//                number = cal(q);
//            } else {
//                switch (prevOp) {
//                    case '+':
//                        sum += prev;
//                        prev = number;
//                        break;
//
//                    case '-':
//                        sum += prev;
//                        prev = -number;
//                        break;
//                }
//                if (c == ')') {
//                    break;
//                }
//                prevOp = c;
//                number = 0;
//            }
//        }
//        return sum + prev;
//    }
}

