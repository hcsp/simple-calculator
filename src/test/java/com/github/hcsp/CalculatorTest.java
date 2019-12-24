package com.github.hcsp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    @ParameterizedTest(name = "{0} == {1}")
    @CsvSource({
        "2,   1+1",
        "2,   (1)+1",
        "2,   (1+1)",
        "2,   ((1)+(1))",
        "5,   (1+2)-(3-7)+(10-12)"
    })
    public void test(int result, String str) {
        Assertions.assertEquals(result, Calculator.calculate(str));
    }
}
