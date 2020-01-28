package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 09:23
 */
public class T121 {

    // 股票买卖问题
    // 暴力解
    // 其实题意就是找两个数字 且差值最大 并且买入价格要低于售出价
    // 这样才能保证是获利最大的
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // prices[j] - prices[i]保证售出价高于买入价
                int disCount = prices[j] - prices[i];
                if (disCount > max)
                    max = disCount;
            }
        }
        return max;
    }

    // 第二种解法
    // 这种最简单的股票问题可以想想成折线图
    // 这样的话只需要找最低的点和最低点后最高的点
    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            if (prices[i] - min > max) max = prices[i] - min;
        }
        return max;
    }

    //
}
