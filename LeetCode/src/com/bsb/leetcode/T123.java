package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 10:37
 */
public class T123 {

    // 股票问题
    // 最多可完成2笔交易
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        // 最多交易次数
        int K = 2;
        int[][] dp = new int[n][K + 1];
        for (int k = 1; k <= K; k++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, prices[i] - dp[i - 1][k - 1]);
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
            }
        }
        return dp[n - 1][K];
    }
}
