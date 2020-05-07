package com.github.hcsp;

public class PowerX50 {
    /**
     * 50. Pow(x, n)
     * <p>
     * Implement pow(x, n), which calculates x raised to the power n (x^n).
     * <p>
     * Example 1:
     * Input: 2.00000, 10
     * Output: 1024.00000
     * <p>
     * Example 2:
     * Input: 2.10000, 3
     * Output: 9.26100
     * <p>
     * Example 3:
     * Input: 2.00000, -2
     * Output: 0.25000
     * Explanation: 2^(-2) = 1/2^2 = 1/4 = 0.25
     * <p>
     * Note:
     * -100.0 < x < 100.0
     * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
     */
    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        if (n > 0) {
            return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x, n - 1);
        }

        return 1 / myPow(x, -n);
    }

    // not recommended! when n is extremely large...
    public static double myPowNonRecursive(double x, int n) {

        double result = 1.0;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = 1; i <= n; i++) {
            result = x * result;
        }

        return result;
    }

    // 快速幂算法！
    // 把 n 进行二进制分解：1， 2， 4， 8...
    public static double myPowNonRecursive2(double x, int n) {
        double result = 1.0;
        long defensiveOfN = n;

        if (defensiveOfN == 0) {
            return result;
        }

        if (defensiveOfN < 0) {
            x = 1 / x;
            defensiveOfN = Math.abs(defensiveOfN);
        }

        while (defensiveOfN > 0) {
            if (defensiveOfN % 2 != 0) {
                result = result * x;
            }

            x = x * x;
            defensiveOfN /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(myPowNonRecursive2(2.00000, 10));
        System.out.println(myPowNonRecursive2(2.10000, 3));
        System.out.println(myPowNonRecursive2(2.00000, Integer.MIN_VALUE));
        System.out.println(myPowNonRecursive2(2.00000, 0));

    }
}
