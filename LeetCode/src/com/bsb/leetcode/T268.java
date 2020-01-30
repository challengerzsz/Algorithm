package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 16:38
 */
public class T268 {


    public int missingNumber(int[] nums) {

        // 寻找缺失的数字 O(n)异或数字异或下标 结果就是缺失的数字
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
