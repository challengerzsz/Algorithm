package com.bsb.leetcode.second;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 15:39
 */
public class T122 {

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) res += prices[i] - prices[i - 1];
        }
        return res;
    }
}
