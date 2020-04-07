package com.bsb.bytedance.prepare.stock;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-07 21:23
 */
public class T714 {

    // 股票VI 带手续费
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        // dp[i][stat] stat: 0 未持股 1持股
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            // 昨天就没持股 或者今天刚卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持股 昨天就持股或者今天刚买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];

    }

}
