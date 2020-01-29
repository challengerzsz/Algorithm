package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 14:33
 */
public class T152 {

    // 我的动态规划
    public int resProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        // dp表示到目前为止子序列的乘积
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(dp[i - 1] * nums[i]) >= Math.abs(dp[i - 1])) dp[i] = dp[i - 1] * nums[i];
            if (dp[i - 1] * nums[i] <= dp[i - 1]) dp[i] = nums[i];
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }


    public int resProduct2(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {0, 2};
        new T152().resProduct(array);
    }
}
