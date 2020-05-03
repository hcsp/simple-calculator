package com.github.hcsp;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSums1 {
    /**
     * 1. two sum
     *
     * Given an array of integers,
     * return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     *
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     */

    // solution 1: brute-force approach
    // time complexity: O(N^2)
    // space complexity: O(N)
    public static int[] twoSum1(int[] nums, int target) {
        // 注意边界！！
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
    // solution 2:
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            }
            map.put(nums[i], i);
        }

        // return new int{0, 0}; 它等价于：new int[2];
        return new int[]{};  // equivalent to new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9) ));
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 10, 11, 15}, 9) ));
        System.out.println(twoSum2(new int[]{2, 10, 11, 15}, 9).length);

    }
}
