package com.bsb.leetcode.interview.simulate.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-03 21:16
 */
public class T2 {

    // 最长回文子串
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        // 每个单个字符都是回文串
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;

        // 每个单个字符都是回文串 max初始化为1
        int max = 1;
        int index = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // j - 1 - (i + 1) + 1 < 2 这个是i～j之间不能组成字串的边界条件 => j - i < 3
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 如果i + 1 ~ j - 1是回文串 那么在这里 dp[i][j]应该也是true
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > max) {
                        max = curLen;
                        index = i;
                    }
                }
            }
        }
        return s.substring(index, index + max);
    }

    public static void main(String[] args) {
        // [left, right)
        System.out.println("123".substring(0, 1));
    }
}
