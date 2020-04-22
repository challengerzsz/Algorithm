package com.bsb.bytedance.prepare.stockII;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 20:58
 */
public class T123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][3];

        for (int k = 1;k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[i][k - 1]);
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
            }
        }

        return dp[prices.length - 1][2];
    }
}
