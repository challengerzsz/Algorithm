package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 18:27
 */
public class T115 {

    // 这题还是有些难 动态规划解还是没看懂 先放一放吧
    public int numDistinct(String s, String t) {

        // LC题解
        // https://leetcode-cn.com/problems/distinct-subsequences/solution/dong-tai-gui-hua-by-powcai-5/
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}
