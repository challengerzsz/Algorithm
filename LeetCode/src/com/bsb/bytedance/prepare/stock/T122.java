package com.bsb.bytedance.prepare.stock;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-02 15:49
 */
public class T122 {

    // 多次交易
    public int maxProfit(int[] prices) {

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        }

        return res;
    }
}
