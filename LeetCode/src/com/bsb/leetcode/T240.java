package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-22 10:52
 */
public class T240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }
}
