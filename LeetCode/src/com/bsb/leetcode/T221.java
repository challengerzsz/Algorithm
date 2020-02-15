package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-22 11:02
 */
public class T221 {

    // 最大正方形面积 这题我记得明明写过题解的
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        // dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // 这里为什么需要考虑3个方向是因为以matrix[i][j]作为正方形的右下角时可以从这三个方向拓展过来
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }


}
