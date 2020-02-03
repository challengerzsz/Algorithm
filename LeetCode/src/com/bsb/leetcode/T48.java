package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 15:20
 */
public class T48 {

    public void rotate(int[][] matrix) {
        // 先转制 再反转每一行
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // 转制
        // 1 4 7
        // 2 5 8
        // 3 6 9
        // 旋转每一行
        // 7 4 1
        // 8 5 2
        // 9 6 3
        int n = matrix.length;

        // 转制
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    // 内部矩形旋转
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // 旋转
    // 7 2 1
    // 4 5 6
    // 9 8 3
    // 旋转
    // 7 4 1
    // 8 5 2
    // 9 6 3
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }
}
