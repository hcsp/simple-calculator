package com.github.hcsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    // 请实现一个简单的计算器，能够计算传入的字符串所代表的表达式的值。
    // 表达式只包含数字、+、-、(、)
    // 你可以假设它一定是一个合法的表达式，且不包含负数
    // 例如，传入字符串"1+1"，返回2
    // 传入字符串"(1+2)-(3-7)+(10-12)"，返回5
    public static int calculate(String str) {

        try {
            boolean ignore = check(str);
            List<Token> tokens = scan(str);
            return getResult(tokens);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static boolean check(String s) {
        return true;
    }

    public static List<Token> scan(String s) throws Exception {
        // Token type
        // 0 num
        // 1 operator
        int type = -1;
        List<Integer> types = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (type != 0) {
                    type = 0;
                    sb.append('#');
                    types.add(type);
                }
            } else {
                type = 1;
                sb.append('#');
                types.add(type);
            }
            sb.append(c);
        }
        String[] strings = sb.substring(1).split("#");

        if (strings.length != types.size()) {
            throw new Exception("");
        }

        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            Token token = new Token(strings[i], types.get(i));
            tokens.add(token);
        }
        tokens.add(new Token("#", 1));
        return tokens;
    }

    public static int getResult(List<Token> tokens) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> SymStack = new Stack<>();
        SymStack.push("#");
        for (Token token : tokens) {
            if (token.type == 0) {
                numStack.push(Integer.parseInt(token.word));
            } else {
                switch (token.word) {
                    case "+":
                    case "-":
                    case "(":
                        SymStack.push(token.word);
                        break;
                    case ")":
                    case "#":
                        int num = 0;
                        String op = null;
                        do {
                            op = SymStack.pop();
                            if ("(".equals(op) || "#".equals(op)) {
                                num += numStack.pop();
                                break;
                            } else if ("+".equals(op)) {
                                num += numStack.pop();
                            } else if ("-".equals(op)) {
                                num -= numStack.pop();
                            }
                        } while (!SymStack.empty());
                        numStack.push(num);
                        break;
                }
            }
        }
        return numStack.pop();
    }

    public static class Token {

        public Token(String word, int type) {
            this.word = word;
            this.type = type;
        }

        String word;
        /**
         * Token type
         * 0 num
         * 1 operator
         */
        int type;

        @Override
        public String toString() {
            return type + ":" + word;
        }
    }
}
