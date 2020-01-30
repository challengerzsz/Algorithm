package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 16:54
 */
public class T300 {

    // 最长上升序列
    // 这种题一看就是动态规划能够解决的问题
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;

        // dp数组表示到每一位能够组成的最长上升序列长度
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 题目要求nlogn 所以二分再来一个
    public int lengthOfLIS2(int[] nums) {
        int[] tag = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tag[m] < num) i = m + 1;
                else j = m;
            }
            tag[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}
