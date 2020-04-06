package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-06 09:55
 */
public class T50 {

    // 快速幂
    public double myPow(double x, int n) {
        if (n < 0) return 1 / helper(x, -n);
        else return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) return 1;

        double part = helper(x, n / 2);

        if ((n & 1) == 1) {
            return x * part * part;
        } else {
            return part * part;
        }
    }

    public static void main(String[] args) {
        System.out.println(new T50().myPow(2.00000, -2147483648));
    }
}
