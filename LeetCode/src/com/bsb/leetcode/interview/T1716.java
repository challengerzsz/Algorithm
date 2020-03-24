package com.bsb.leetcode.interview;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-24 19:56
 */
public class T1716 {

    // 题目名字叫按摩师
    // 第一次dp解不对 65 / 69 dp[1]初始化的问题
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
//        dp[1] = nums[1];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
