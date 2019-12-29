package com.github.hcsp;

import java.util.ArrayDeque;
import java.util.Queue;


public class Calculator {
    // 请实现一个简单的计算器，能够计算传入的字符串所代表的表达式的值。
    // 表达式只包含数字、+、-、(、)
    // 你可以假设它一定是一个合法的表达式，且不包含负数
    // 例如，传入字符串"1+1"，返回2
    // 传入字符串"(1+2)-(3-7)+(10-12)"，返回5
    public static int calculate(String str) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                q.offer(c);
            }
        }
        q.offer(' ');
        return cal(q);
    }

    private static int cal(Queue<Character> q) {
        int number = 0;
        int prev = 0;
        int sum = 0;
        char prevOp = '+';

        while (!q.isEmpty()) {
            char c = q.poll();

            if (c >= '0' && c <= '9') {
                number = number * 10 + (c - '0');
            } else if (c == '(') {
                number = cal(q);
            } else {
                switch (prevOp) {
                    case '+':
                        sum += prev;
                        prev = number;
                        break;

                    case '-':
                        sum += prev;
                        prev = -number;
                        break;
                }

                if (c == ')') {
                    break;
                }
                prevOp = c;
                number = 0;
            }
        }
        return sum + prev;
    }
}

