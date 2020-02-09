package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 14:44
 */
public class T714 {

    // 买卖股票含手续费
    // 比如 1 3 2 8 4 9 fee = 2
    //                       9
    //              8   \   /
    //             /      4
    //      3   \
    //     /     2
    //  1
    // 首先需要明白 如果到最后一天手上还拿着股票 那肯定是亏的
    // 动态规划解
    // dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益。
    // j一共两个状态 0表示不持股 1表示持股
    // dp[i][0] 表示今日不持股 昨天可能也没有持股dp[i - 1][0] 或者昨天持股 今天卖出了 dp[i - 1][1] + price[i]取最大
    // dp[i][1] 表示今日持股 昨天可能持股今天没干什么dp[i - 1][1]
    // 或者今天又买了一股 dp[i - 1][0] - price[i] - fee 在买入的时候就计算手续费
    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }
}
