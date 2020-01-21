package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 22:01
 */
public class T209 {

    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int i = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (i < nums.length) {
            if (sum + nums[i] < s) {
                sum = sum + nums[i];
                i++;
            } else {
                len = Math.min(len, i - start + 1);
                sum = sum - nums[start];
                start++;

            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
