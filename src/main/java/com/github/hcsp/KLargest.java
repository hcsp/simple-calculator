package com.github.hcsp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargest {
/**
 *
 * 215. Kth largest element in an array
 *
 * Find the kth largest element in an unsorted array.
 *  Note that it is the kth largest element in the sorted order,
 *  not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

    // solution 1:
    // time complexity: O(N * lgN)
    // space complexity: O(N)
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    // solution 2:
    // time complexity: O(lgN)
    // space complexity: O(N)
    public static int findKthLargest2(int[] nums, int k) {
        final PriorityQueue<Integer> q = new PriorityQueue<>(k);

        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

}
