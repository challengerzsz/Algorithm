package com.bsb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-02 10:51
 */
public class T73 {

    // 矩阵置0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 题目要求空间O(1)
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int c = 0; c < n; c++) {
                if (matrix[i][c] == 0) {
                    // 标记为0的行和列
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = Integer.MIN_VALUE;
                        }
                    }
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][c] != 0) {
                            matrix[k][c] = Integer.MIN_VALUE;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int c = 0; c < n; c++) {
                // 还原
                if (matrix[j][c] == Integer.MIN_VALUE) {
                    matrix[j][c] = 0;
                }
            }
        }
    }
}
