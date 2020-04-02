package com.bsb.bytedance.prepare.stock;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-02 15:52
 */
public class T123 {

    // 最多2次交易
    // 222 / 222超时
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][3];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j <= i; j++) {
                    max = Math.max(j == 0 ? prices[i] - prices[j] : prices[i] - prices[j] + dp[j][k - 1], max);
                    dp[i][k] = Math.max(dp[i - 1][k], max);
                }
            }
        }

        return dp[prices.length - 1][2];
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int K = 2;
        int[][] dp = new int[prices.length][K + 1];
        for (int k = 1; k <= K; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                // 就还是每一次能交易的情况下找波谷和波峰
                // 找出第 1 天到第 i 天 prices[buy] - dp[buy][k - 1] 的最小值
                min = Math.min(prices[i] - dp[i][k - 1], min);
                // 比较不操作和选择一天买入的哪个值更大
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
            }
        }
        return dp[prices.length - 1][K];
    }

}
