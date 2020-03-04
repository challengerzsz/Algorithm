package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 15:27
 */
public class T5 {

    // 最长回文子串
    // 中心拓展
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            int selfLen = expand(s, i, i);
            int betweenLen = expand(s, i, i + 1);
            int max = Math.max(selfLen, betweenLen);
            if (max > right - left) {
                left = i - (max - 1) / 2;
                right = i + max / 2;
            }
        }

        // subString [i, j)
        return s.substring(left, right + 1);
    }

    private int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) break;
            i--;
            j++;
        }
        // 这里注意是-1 因为此时i j已经到了回文串的左右两侧
        return j - i - 1;
    }


    public String longestPalindromeDp(String s) {

        if (s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化 每一个单个字符都是回文串
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;

        int max = 1;
        int start = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                // 因为我们的区间是[i, j] 所以i > j的情况就直接break就好了
                if (i > j) break;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    int len = j - i + 1;
                    if (len > max) {
                        start = i;
                        max = len;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }


}
