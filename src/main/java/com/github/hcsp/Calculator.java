package com.github.hcsp;

import java.util.Deque;
import java.util.LinkedList;

public class Calculator {
    // 请实现一个简单的计算器，能够计算传入的字符串所代表的表达式的值。
    // 表达式只包含数字、+、-、(、)
    // 你可以假设它一定是一个合法的表达式，且不包含负数
    // 例如，传入字符串"1+1"，返回2
    // 传入字符串"(1+2)-(3-7)+(10-12)"，返回5
    public static int calculate(String str) {
        Deque<Object> stack = new LinkedList<>();
        int num = 0;
        int n = 0;
        //使用栈来处理，从后往前向栈里加数据
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            //提取数字
            if (Character.isDigit(ch)) {
                num = (int) (Math.pow(10, n) * (ch - '0') + num);
                n += 1;
            } else if (ch != ' ') {
                if (n != 0) {
                    //入栈
                    stack.push(num);
                    n = 0;
                    num = 0;
                }
                if (ch == '(') {
                    //一个括号里的加完了，算出结果，重新放入栈中
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);
                } else {
                    stack.push(ch);
                }
            }
        }
        //最后
        if (n != 0) {
            stack.push(num);
        }
        return evaluateExpr(stack);
    }

    //使用栈进行计算
    private static int evaluateExpr(Deque<Object> stack) {
        int res = 0;
        if (!stack.isEmpty()) {
            res = (int) stack.pop();
        }
        while (!stack.isEmpty() && (char) stack.peek() != ')') {
            char sign = (char) stack.pop();
            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }
}
