package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 17:05
 */
public class T85 {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int max = 0;
        // 每个点对应的最大宽度
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        max = Math.max(max, width * (i - k + 1));
                    }
                }
            }
        }
        return max;
    }
}
