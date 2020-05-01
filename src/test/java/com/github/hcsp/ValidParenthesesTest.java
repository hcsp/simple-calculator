package com.github.hcsp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidParenthesesTest {

    @ParameterizedTest(name = "{0} == {1}")
    @CsvSource({
            "true,  {}",
            "false, {]",
            "false, ([)]",
            "true, {[]}",
            "true,  ''"  // specify empty string by supplying two adjacent single-quotes
    })
    void testIsValid(boolean result, String str) {  // result type is boolean!
        Assertions.assertEquals(result, ValidParentheses.isValid(str));
    }
}
