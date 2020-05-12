package com.github.hcsp;

/**
 * 278. first bad version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */
public class FirstBadVersion278 {
    /**
     * The isBadVersion API is defined in the parent class FirstBadVersion278.
     * boolean isBadVersion(int version);
     */

    private static int FIRST_BAD = 4;

    // recursive way:
    // space complexity: O(logn)
    // time complexity: O(logn)
    public static int firstBadVersion1(int n) {
        if (n == 0) {
            return 0;
        }
        return helper(n, 1, n);
    }

    private static int helper(int n, int low, int high) {
        if (low == high) {
            return low;
        }

        int middle = (low + high) / 2;

       return isBadVersion(middle) ? helper(n, low, middle) : helper(n, middle + 1, high);
    }


    // time complexity: O(logn)
    // space complexity: O(1)
    public static int firstBadVersion2(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            // avoid integer overflow possibilita'!! nice!!
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                // NB：大坑一个！Forget Not!
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isBadVersion(int version) {
        if (version >= FIRST_BAD) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion1(10));
//        System.out.println(firstBadVersion2(10));

    }
}
