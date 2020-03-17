package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-17 21:54
 */
public class T32 {

    // 最长有效括号 dp
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        // dp[0]自然为0 一个字符不可能组成括号
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) dp[i] = dp[i - 2] + 2;
                    else dp[i] = 2;
                }
                // 找从i开始往前的dp[i - 1]位的前一位是不是( 是的话就继续扩大max
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
