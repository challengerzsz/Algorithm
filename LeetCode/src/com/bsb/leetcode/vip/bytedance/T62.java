package com.bsb.leetcode.vip.bytedance;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-31 20:20
 */
public class T62 {

    // 不同路径
    // dfs可以做 但是大量回溯加重复计算 可以用记忆化优化 但是不是最优解
    public int uniquePaths(int m, int n) {
        // dp[i][j]表示走到{i, j}有多少种走法
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) dp[i][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        new T62().uniquePaths(3, 2);
    }
}
