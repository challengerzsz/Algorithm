package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-18 12:19
 */
public class T63 {

    // 不同路径升级版 中加增加障碍 但是动态规划的思路不变
    // dp数组位置如果是障碍的话直接置为0就好了
    // 只不过初始化dp数组的时候需要注意 如果第一行和第一列出现中途有障碍 那后续位置都到不了
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                for (int k = i + 1; k < obstacleGrid[0].length - 1; k++) {
                    dp[0][k] = 0;
                }
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                for (int k = i + 1; k < obstacleGrid.length - 1; k++) {
                    dp[k][0] = 0;
                }
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] array = {{1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0}};
        new T63().uniquePathsWithObstacles(array);


    }
}
