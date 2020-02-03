package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 16:04
 */
public class T64 {

    // 最小路径和
    // 这题脑子里第一想法就是动态规划
    // dp数组的每一项都表示走到该位置的最小路径和
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        // 初始化dp数组的第一行和第一列
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        new T64().minPathSum(array);
    }
}
