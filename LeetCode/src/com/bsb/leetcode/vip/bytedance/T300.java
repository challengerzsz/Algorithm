package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-14 21:28
 */
public class T300 {

    // 最长上升序列
    // dp[i]表示以i下标结尾的最长上升子序列长度
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int cur = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    cur = Math.max(cur, dp[j]);
                }
            }
            // +1的目的是为了选择自己 此时的cur还没有包括选择自己
            dp[i] = cur + 1;
            // 更新最大res
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
