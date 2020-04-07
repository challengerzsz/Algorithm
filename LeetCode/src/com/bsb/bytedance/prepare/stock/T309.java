package com.bsb.bytedance.prepare.stock;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-07 20:58
 */
public class T309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        // dp[i][stat] 表示第i天在stat状态时最大收益
        // dp[i][0]表示当日不持股
        // dp[i][1]表示当日持股
        // dp[i][2]表示当日卖出
        int[][] dp = new int[n][3];
        // 初始化第0天的数据
        // 不持股0
        dp[0][0] = 0;
        // 持股 说明第0天买入dp[0][1] = -price[0]
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            // 今日未持股 要么就是昨天也没持股 要么就是昨天刚卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 今日持股 要么是昨天就持股今天不操作 要么是昨日刚买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 今日卖出 肯定是昨日持股今日卖
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        // 最后的结果只可能出现在stat为0即不持股和为2最后一天卖出的最大值
        // 最后肯定是要把股票卖出去 才有可能获得最大收益
        return Math.max(dp[n - 1][0], dp[n - 1][2]);

    }
}
