package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 17:05
 */
public class T85 {

    // 这题在之前也是凑数题
    // 最大矩阵的面积其实比较容易思考
    // 找到可以作为矩形的对角线尽头两端点 即可计算出最后的矩形面积大小
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int max = 0;
        // dp[i][j]表示 在第i行以第j列元素为结尾 能够构成的最长边长是多少
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // 如果是第0列 并且matrix[i][j] == 1那么dp[i][j] = 1
                    // 否则的话根据上面dp数组的定义 dp[i][j] 应该是第i行加上j之后能够构成的最大矩形边长
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                    // 计算以matrix[i][j]为矩形的右下角点能够构成的最大矩形面积
                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        // 这里需要考虑到第k行第j列的最长矩形边长要是最小的
                        // 因为如果不能保证最小的话也就意味这计算出来的矩形中不可能全部为1
                        width = Math.min(width, dp[k][j]);
                        max = Math.max(max, width * (i - k + 1));
                    }
                }
            }
        }
        return max;
    }
}
