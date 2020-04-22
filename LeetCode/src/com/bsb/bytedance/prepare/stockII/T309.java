package com.bsb.bytedance.prepare.stockII;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 21:13
 */
public class T309 {

    // 冷冻期
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][3];
        // 0 未持股
        // 1 持股
        // 2 售出

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] - prices[i];
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);

    }
}
