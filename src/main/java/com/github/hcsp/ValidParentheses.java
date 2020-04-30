package com.github.hcsp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    // Given a string containing below characters:
    //      '(', ')', '{', '}', '[' and ']'.
    // input string is valid if:
    //     1. open brackets must be closed by the same type of brackets.
    //     2. open brackets must be closed in the correct order.
    //     3. empty string is considered valid.

    public static boolean isValid(String str) {
        Map<Character, Character> pattern = new HashMap<>();
        pattern.put(')', '(');
        pattern.put('}', '{');
        pattern.put(']', '[');

        Deque<Character> container = new ArrayDeque<>();

        if ("".equals(str)) {
            return true;
        }

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                container.push(c);
            } else {
                if (!container.isEmpty() && pattern.get(c) != container.pop()) {
                    return false;
                }
            }
        }
        return container.isEmpty();
    }
}
