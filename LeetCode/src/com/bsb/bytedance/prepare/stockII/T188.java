package com.bsb.bytedance.prepare.stockII;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 21:02
 */
public class T188 {

    // k次交易
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k > prices.length / 2) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
            }
            return res;
        }

        int[][] dp = new int[prices.length][k + 1];
        for (int K = 1; K <= k; K++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[i][K - 1]);
                dp[i][K] = Math.max(dp[i - 1][K], prices[i] - min);
            }
        }

        return dp[prices.length - 1][k];
    }
}
