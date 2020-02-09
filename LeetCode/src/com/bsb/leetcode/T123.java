package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 10:37
 */
public class T123 {

    // 股票问题
    // 最多可完成2笔交易
    // 这题没记错当时是为了凑数直接搬上来的..
    // 今天回顾一下股票问题针对这个只能交易2次的题目怎么做动态规划的变型
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        // 最多交易次数
        int K = 2;
        int[][] dp = new int[n][K + 1];
        // debug之后 + 草稿纸发现 dp[i][k]表示 本轮只有k次交易机会的时候到了第i天的最大收入
        // 其实这里的最外层循环是为了枚举k = 0, 1, 2的时候dp数组可能出现的情况
        // 不从k = 0开始是因为k是本题的有效交易次数 如果k == 0也就说明不能够进行交易
        for (int k = 1; k <= K; k++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                // 因为对每一次的内层循环来说 本次循环只允许交易1次 如果明白这个 那其实下面的两行代码就是在找波谷和波峰做差
                // 也即 dp[n - 1][k]为本轮一次交易之后的最大利润
                min = Math.min(min, prices[i] - dp[i - 1][k - 1]);
                // 每一趟都需要更新到了第i天的时候出现的最大利润
                // 可以是在第i天无操作 也可以是在第i天卖出
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
            }
        }
        return dp[n - 1][K];
    }

    public static void main(String[] args) {
        int[] array = {3, 3, 5, 0, 0, 3, 1, 4};
        new T123().maxProfit(array);
    }
}
