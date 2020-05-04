package com.github.hcsp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15Test {
    int[] ints = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));

    @Test
    public void testThreeSum1() {
        Assertions.assertEquals(result, ThreeSum15.threeSum1(ints));
    }

    @Test
    public void testThreeSum2() {
        Assertions.assertEquals(result, ThreeSum15.threeSum2(ints));
    }

    @Test
    public void testThreeSum3() {
        Assertions.assertEquals(result, ThreeSum15.threeSum3(ints));
    }

    @Test
    public void testThreeSum4() {
        Assertions.assertEquals(result, ThreeSum15.threeSum3(ints));
    }
}