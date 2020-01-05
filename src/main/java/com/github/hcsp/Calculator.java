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


    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (number != 0) result += sign * number;
        return result;

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

