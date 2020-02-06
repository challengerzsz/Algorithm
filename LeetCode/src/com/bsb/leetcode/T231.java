package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-06 19:06
 */
public class T231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
