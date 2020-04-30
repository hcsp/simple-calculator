package com.github.hcsp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ValidParenthesesTest {

    @Test
    public void testIsValid() {
        Assertions.assertTrue(ValidParentheses.isValid("()"));
        Assertions.assertFalse(ValidParentheses.isValid("(]"));
        Assertions.assertFalse(ValidParentheses.isValid("([)]"));
        Assertions.assertTrue(ValidParentheses.isValid("{[]}"));
        Assertions.assertTrue(ValidParentheses.isValid(""));
    }
}