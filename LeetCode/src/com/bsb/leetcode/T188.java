package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 17:02
 */
public class T188 {

    // 买卖股票的第4个问题
    // 限制最大交易次数
    // 题目给定为k
    // 如果此时建立一个三维数组dp[n][k][m] k是交易次数 m是是否持有股票的状态 k如果过大的时候直接就会超出内存限制
    // 这里就需要对k的大小进行有效的优化
    // 一次交易至少需要 2 天，一天买，一天卖。因此如果 k 很大，大到大于等于 len / 2这其实就是一般的贪心解就好了
    // 也就是说k大于n/2的时候k也就没有了限制作用
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if (n == 0) return 0;

        if (k >= n / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    max += prices[i] - prices[i - 1];
            }
            return max;
        }
        // 最多交易次数
        int[][] dp = new int[n][k + 1];
        // debug之后 + 草稿纸发现 dp[i][k]表示 本轮只有k次交易机会的时候到了第i天的最大收入
        // 其实这里的最外层循环是为了枚举k = 0, 1, 2的时候dp数组可能出现的情况
        // 不从k = 0开始是因为k是本题的有效交易次数 如果k == 0也就说明不能够进行交易
        for (int j = 1; j <= k; j++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                // 因为对每一次的内层循环来说 本次循环只允许交易1次 如果明白这个 那其实下面的两行代码就是在找波谷和波峰做差
                // 也即 dp[n - 1][k]为本轮一次交易之后的最大利润
                min = Math.min(min, prices[i] - dp[i - 1][j - 1]);
                // 每一趟都需要更新到了第i天的时候出现的最大利润
                // 可以是在第i天无操作 也可以是在第i天卖出
                dp[i][j] = Math.max(dp[i - 1][j], prices[i] - min);
            }
        }
        return dp[n - 1][k];
    }
}
