package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-18 11:59
 */
public class T62 {

    // 普通回溯 通过50% 超时
    private int count = 0;

    public int uniquePaths(int m, int n) {
        helper(0, 0, m, n);
        return count;
    }

    private void helper(int r, int c, int m, int n) {
        if (r == m || c == n) return;
        if (r == m - 1 && c == n - 1) {
            count++;
            return;
        }
        helper(r, c + 1, m, n);
        helper(r + 1, c, m, n);
    }

    // 动态规划
    public int uniquePathsByDp(int m, int n) {
        // dp数组表示走到当前位置时最多的可行路径数量
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
