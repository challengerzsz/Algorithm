package com.bsb.bytedance.prepare.stock;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-02 10:48
 */
public class T121 {

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < min) min = prices[i - 1];
            if (prices[i] - min > res) res = prices[i] - min;
        }
        return res;
    }

    public static void main(String[] args) {
        new T121().maxProfit(new int[]{1, 2});
    }
}
