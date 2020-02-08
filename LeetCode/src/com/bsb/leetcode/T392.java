package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-08 15:55
 */
public class T392 {

    // indexOf利用这个api 85%时间
    public boolean isSubsequence(String s, String t) {
        int i = -1;
        for (char c : s.toCharArray()) {
            i = t.indexOf(c, i + 1);
            if (i == -1) {
                return false;
            }
        }
        return true;
    }

    // 动态规划解
    // dp[i][j]表示状态为 s的第0～i个字符是不是t的0～j字符的字串(这里的字串包括可以删除多余元素)
    public boolean isSubsequence2(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (sLength > tLength) return false;
        if (sLength == 0) return true;
        boolean[][] dp = new boolean[sLength + 1][tLength + 1];
        // 初始化 空s串一定是t的字串
        for (int j = 0; j < tLength; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= tLength; j++) {
                // 如果s的第i字符和t的第j字符相等 dp[i][j] = dp[i - 1][j - 1]
                // 如果不 dp[i][j] = dp[i][j - 1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[sLength][tLength];
    }
}
