package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-12 21:30
 */
public class T132 {

    // 分割字符串II
    // 最小分割次数
    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }

        // dp[i]表示s[0, i]的串中分割成多个回文串的最小次数
        // s[0, 1]本来就是一个回文串 也就是第一个字符自己构成一个回文串 所以dp[0] = 0
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < len; i++) {
            if (helper(s, 0, i)) {
                dp[i] = 0;
                continue;
            }
            // 寻找s[0, i]之间的可能的切割点
            // 当 j == i 成立的时候，s[i] 就一个字符，一定是回文
            // 因此，枚举到 i - 1 即可
            // 如果s[j + 1, i]是一个回文串 dp[i]就是在dp[j]上多一个分割
            // 枚举j的所有位置 最小的dp[j] + 1 = dp[i]
            for (int j = 0; j < i; j++) {
                if (helper(s, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    // 判断是不是回文串
    private boolean helper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
