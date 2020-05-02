package com.github.hcsp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KLargestTest {
    @Test
    public void testFindKthLargest1() {
        int[] nums1 = new int[]{3,2,3,1,2,4,5,5,6};
        int[] nums2 = new int[]{3,2,1,5,6,4};

        Assertions.assertEquals(4, KLargest.findKthLargest1(nums1, 4));
        Assertions.assertEquals(5, KLargest.findKthLargest1(nums2, 2));
    }

    @Test
    public void testFindKthLargest2() {
        int[] nums1 = new int[]{3,2,3,1,2,4,5,5,6};
        int[] nums2 = new int[]{3,2,1,5,6,4};

        Assertions.assertEquals(4, KLargest.findKthLargest2(nums1, 4));
        Assertions.assertEquals(5, KLargest.findKthLargest2(nums2, 2));
    }
}