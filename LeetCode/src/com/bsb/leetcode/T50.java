package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 21:50
 */
public class T50 {

    public double myPow(double x, int n) {
        long t = n;
        if (t < 0) {
            x = 1 / x;
            t = -t;
        }
        // 示例是双浮点数
        double ans = 1;
        for (long i = 0; i < t; i++) ans = ans * x;
        return ans;
    }
}
