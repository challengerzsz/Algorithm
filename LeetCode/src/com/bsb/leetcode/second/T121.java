package com.bsb.leetcode.second;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 15:32
 */
public class T121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int temp : prices) {
            if (temp < min) min = temp;
            if (temp - min > res) res = temp - min;
        }
        return res;
    }
}
