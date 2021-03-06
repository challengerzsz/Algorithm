package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-06 19:46
 */
public class T72 {

    // 编辑距离
    // dp[i][j] 表示word1[0 ～ i] 到word2[0 ~ j]的编辑距离
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 填充第一行和第一列意思是word1[0 ~ i]到空串的编辑距离
        // 第一行
        for (int j = 1; j <= word2.length(); j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= word1.length(); i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // 不做操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
