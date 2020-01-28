package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 16:21
 */
public class T136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int temp : nums) {
            res ^= temp;
        }
        return res;
    }
}
