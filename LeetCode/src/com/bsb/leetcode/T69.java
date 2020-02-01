package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-01 17:12
 */
public class T69 {

    public int mySqrt(int x) {
        // 二分找平方根
        if (x == 1) return 1;
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = (max + min) / 2;
            if (x / m < m)
                max = m;
            else
                min = m;
        }
        return min;
    }
}
