package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 21:19
 */
public class T53 {

    // 最大子序和
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int temp : nums) {
            // 其实就是sum + temp > temp
            if (sum > 0) sum += temp;
            else sum = temp;

            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSubArrayGreed(int[] nums) {
        int res = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }


    // dp解
    public int maxSubArrayDp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;

        // dp[i] 表示前 i 个元素的最大连续子数组的和
        int[] dp = new int[nums.length];

        // 初始化
        dp[0] = nums[0];
        res = nums[0];

        // dp[i] = max(dp[i - 1], 0) + nums[i]
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
