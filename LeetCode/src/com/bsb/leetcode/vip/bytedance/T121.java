package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 11:23
 */
public class T121 {

    // 只允许交易一次的股票
    public int maxProfit(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for (int temp : prices) {
            min = Math.min(temp, min);
            res = Math.max(res, temp - min);
        }
        return res;
    }
}
