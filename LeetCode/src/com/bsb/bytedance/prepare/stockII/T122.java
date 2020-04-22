package com.bsb.bytedance.prepare.stockII;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 20:57
 */
public class T122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        }

        return res;
    }
}
