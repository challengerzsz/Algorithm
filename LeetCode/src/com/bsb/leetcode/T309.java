package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-23 16:39
 */
public class T309 {

    // 买卖股票的最佳时机
    // 包含冷冻期 不能在售出的第二天买入 冷冻期为1天
    // dp解
    // dp[i, j] j两个取值 一个为0表示未持股 1表示持股
    // dp数组表示第i天j状态下的最大收益
    // 其实按理说这里应该维护一个dp数组进行填表 但是这题没必要 还是同样的去优化dp数组占用的空间
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 初始化dp0和dp1
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        // dp2DaysAgo其实在后续的迭代过程中保存的是dp[i - 2][0]的值
        // 表示在第i - 2天完成了售出操作 并且i - 1这一天是冻结状态
        int dp2DaysAgo = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            // dp0更新为继续未持股即无操作 或者 从dp1状态售出股票的最大值
            dp0 = Math.max(dp0, dp1 + prices[i]);
            // dp1的值更新为在前两天售出股票 以及 继续持股的最大值
            dp1 = Math.max(dp1, dp2DaysAgo - prices[i]);
            dp2DaysAgo = temp;
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        new T309().maxProfit(prices);
    }
}
