package com.github.hcsp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class PowerX50Test {

    @ParameterizedTest(name = "{0} == pow({1}, {2})")
    @CsvSource({
            "1024.00000, 2.00000, 10",
            "9.26100, 2.10000, 3",
            "0.25000,    2.00000, -2"
    })
    void testMyPow(double result, double input, int power) {
        Assertions.assertEquals(String.format("%.5f", result), String.format("%.5f", PowerX50.myPow(input, power)));
    }
}