package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 15:29
 */
public class T279 {

    // 完全平方数
    // 找到最少的完全平方数 使得它们的和等于n
    // 动态规划
    // dp[i]表示i需要的最少的完全平方数的数量
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
