package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-04 11:18
 */
public class T91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, 0);
    }

    // 自底向上
    private int helper(String s, int index) {
        if (s.length() == index) {
            return 1;
        }
        // 以0位开始的串解码不存在对应字符
        if (s.charAt(index) == '0') {
            return 0;
        }
        // index的后两位求和小于等于26，  
        // helper(s, index) = helper(s, index+1) + helper(s, index+2)
        // 否则helper(s, index) = helper(s, index+1)
        int res1 = helper(s, index + 1);
        int res2 = 0;
        if (index < s.length() - 1) {
            int high = (s.charAt(index) - '0') * 10;
            int low = (s.charAt(index + 1) - '0');
            if (high + low <= 26) {
                res2 = helper(s, index + 2);
            }
        }
        return res1 + res2;
    }

    // 动态规划解
    // dp数组表示以某元素为开始时能够解码出的答案数量
    // 也是自底向上的一种动态规划解
    // 当s[i] + s[i + 1] <= 26时 dp[i] = dp[i + 1] + dp[i + 2]
    // else dp[i] = dp[i + 1]
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        // dp数组特殊处理 尾部元素就不用特殊处理了
        int[] dp = new int[len + 1];
        dp[len] = 1;
        // s[i] = 0的时候dp[i] = 0
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
