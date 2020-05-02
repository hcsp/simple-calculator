package com.github.hcsp;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t,
 * write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters?
 * How would you adapt your solution to such case?
 *
 */
public class ValidAnagram {
    // solution 1: Use Map
    // time complexity: O(N)
    // space complexity: O(N)
    public static boolean isAnagram1(String s, String t) {

        Map<Character, Integer> sMap = charFrequencyCount(s);
        Map<Character, Integer> tMap = charFrequencyCount(t);

        return sMap.equals(tMap);
    }

    private static Map<Character, Integer> charFrequencyCount(String s) {
//        return s.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.toMap(Function.identity(), c -> 1, Math::addExact));
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
    }

    // solution 2: compare sorted char arrays.
    // time complexity: O(N * logN)
    // space complexity: O(N)
    public static boolean isAnagram2(String s, String t) {
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();

        Arrays.sort(arrayS);
        Arrays.sort(arrayT);

        return Arrays.equals(arrayS, arrayT);
    }
}
