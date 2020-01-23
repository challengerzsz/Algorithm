package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-23 17:59
 */
public class T233 {

    public int countDigitOne(int n) {
        int count = 0;
        int mutil = 1;
        int left = n;
        int right = 0;
        if (n == 0) {
            return 0;
        }
        while (left > 0) {
            int digit = left % 10;
            left /= 10;
            if (digit == 1) {
                count += left * mutil;
                count += right + 1;
            } else if (digit < 1) {
                count += left * mutil;
            } else {
                count += (left + 1) * mutil;
            }
            right += digit * mutil;
            mutil *= 10;
        }
        return count;
    }
}
