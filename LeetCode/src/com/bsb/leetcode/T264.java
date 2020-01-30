package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 17:46
 */
public class T264 {


    // dp保存按序排列的丑数，三指针分别是*2，*3，*5，找出下一个丑数
    // 这个题目忘记像之前的哪一题了 也是直接*因数寻找下一个数
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int j = 0, k = 0, l = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[j] * 2, Math.min(dp[k] * 3, dp[l] * 5));
            if (min == dp[j] * 2) j++;
            if (min == dp[k] * 3) k++;
            if (min == dp[l] * 5) l++;
            dp[i] = min;
        }

        return dp[n - 1];
    }
}
