package com.bsb.bytedance.prepare.stock;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-07 18:58
 */
public class T188 {

    // 股票IV
    // 允许K次交易
    // 209 / 211 内存超出限制
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;

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

    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        // 最多其实就是交易n / 2次 一买一卖算1次交易 一共两天
        // 其实在这里就是无限制次数的交易
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        // 如果交易次数小于n / 2次
        int[] dp = new int[k + 1];
        int min[] = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            min[i] = prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int K = 1; K <= k; K++) {
                min[K] = Math.min(prices[i] - dp[K - 1], min[K]);
                dp[K] = Math.max(dp[K], prices[i] - min[K]);
            }
        }
        return dp[k];
    }
}
