package com.bsb.bytedance.prepare.stockII;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 20:55
 */
public class T121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            res = Math.max(prices[i] - min, res);
        }

        return res;
    }
}
