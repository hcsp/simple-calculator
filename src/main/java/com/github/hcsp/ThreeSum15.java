package com.github.hcsp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum15 {
    /**
     * 15. 3sum
     *
     * Given an array nums of n integers,
     * are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     *
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     * A solution set is:
     * [
     *   [-1, -1, 2],
     *   [-1, -1, 2]
     * ]
     *
     *
     *
     */

    // solution 1: brute-force + trick to remove duplicates!
    // naive approach to remove duplicates does the work too, but no fun.
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int[] copiedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copiedArray);

        for (int i = 0; i < copiedArray.length-2; i++) {
            if (i != 0 && copiedArray[i] == copiedArray[i-1]) {
                continue;
            }
            for (int j = i+1; j < copiedArray.length-1; j++) {
                if (j != i+1 && copiedArray[j] == copiedArray[j-1]) {
                    continue;
                }
                for (int k = j+1; k < copiedArray.length; k++) {
                    if (k != j+1 && copiedArray[k] == copiedArray[k-1]) {
                        continue;
                    }
                    if (copiedArray[i] + copiedArray[j] + copiedArray[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(copiedArray[i]);
                        temp.add(copiedArray[j]);
                        temp.add(copiedArray[k]);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    // solution 2: HashMap, two sum's way.
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int[] copied = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copied);

        for (int i = 0; i < copied.length-1; i++) {
            // every pass of i iteration, the map is cleared, nice!
            Map<Integer, Integer> map = new LinkedHashMap<>();

            if (i != 0 && copied[i] == copied[i-1]) {
                continue;
            }
            int diff = 0 - copied[i];
            for (int j = i+1; j < copied.length; j++) {
                if (map.containsKey(diff - copied[j]) && map.get(diff-copied[j]) != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(copied[i]);
                    list.add(copied[j]);
                    list.add(diff - copied[j]);
                    result.add(list);
                }
                map.put(copied[j], j);
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 对输入排序，改变了输入，这样做好吗？
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            Map<Integer, Integer> map = new LinkedHashMap<>();

            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int diff = 0 - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (map.containsKey(diff - nums[j]) && map.get(diff-nums[j]) != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(diff - nums[j]);
                    result.add(list);
                }
                map.put(nums[j], j);
            }
        }
        return result;
    }

    // solution 4: two pointers!
    // ordered input + Set, making things easier! My fav!
    public static List<List<Integer>> threeSum4(int[] nums) {
        // ordered array is extremely important! guarantee lots o' things!
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;
            while(leftPointer < rightPointer) {
                if (nums[i] + nums[leftPointer] + nums[rightPointer] == 0) {
                    // found!
                    set.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));
                    leftPointer++;
                    rightPointer--;
                } else if (nums[i] + nums[leftPointer] + nums[rightPointer] < 0) {
                    // nums[i] 固定的情况下，三数和小于0，说明需要一个稍大的数，于是左指针右移一位
                    leftPointer++;
                } else {
                    // opposite case of above：需要一个稍小的数，把右指针左移一位
                    rightPointer--;
                }
            }
        }
        // always use constructor to copy plz!
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum4(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
