package com.github.hcsp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {
    @ParameterizedTest(name = "{0} : {1}, {2}")
    @CsvSource({
            "true, anagram, nagaram",
            "false, rat, car",
            "true, rat, tar"
    })
    void testIsAnagram(boolean result, String s, String t) {
        Assertions.assertEquals(result, ValidAnagram.isAnagram1(s, t));
    }
}