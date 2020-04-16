package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-16 09:50
 */
public class T1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int len1 = t1.length;
        int len2 = t2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++)
                dp[i][j] = t1[i - 1] == t2[j - 1] ? (dp[i - 1][j - 1] + 1) : Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
        return dp[len1][len2];
    }
}
