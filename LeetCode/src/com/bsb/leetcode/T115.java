package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 18:27
 */
public class T115 {

    // T95思路
    public int numDistinct(String s, String t) {

        // dp[i][j]表示S的前j个字符有几种方式构成T的前i个字符
        // 若T[i-1] == S[j-1] T[i−1]==S[j−1]
        // 此时dp[i][j] = dp[i-1][j-1] + dp[i][j-1] dp[i][j] = dp[i−1][j−1] + dp[i][j−1]
        // 否则 dp[i][j] = dp[i][j-1] dp[i][j] = dp[i][j−1]
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
