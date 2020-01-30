package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 17:36
 */
public class T263 {

    // 丑数
    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }
}
