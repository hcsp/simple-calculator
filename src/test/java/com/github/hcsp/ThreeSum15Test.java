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
        assertListEqualsIgnoringOrder(result, ThreeSum15.threeSum1(ints));
    }
    
    private void assertListEqualsIgnoringOrder(List<List<Integer>> list1, List<List<Integer>> list2) {
        Assertions.assertEquals(list1.size(), list2.size());
        for(int i=0;i<list1.size();++i) {
            Assertions.assertEquals(list1.get(0).stream().sorted().collect(toList()),
                                   list2.get(0).stream().sorted().collect(toList()))
        }
    }

    @Test
    public void testThreeSum2() {
        assertListEqualsIgnoringOrder(result, ThreeSum15.threeSum2(ints));
    }

    @Test
    public void testThreeSum3() {
        assertListEqualsIgnoringOrders(result, ThreeSum15.threeSum3(ints));
    }

    @Test
    public void testThreeSum4() {
        assertListEqualsIgnoringOrder(result, ThreeSum15.threeSum3(ints));
    }
}
