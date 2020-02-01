package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-01 17:26
 */
public class T74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 视为一维数组进行二分
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int index, p;
        while (left <= right) {
            index = (left + right) / 2;
            p = matrix[index / n][index % n];
            if (target == p) return true;
            else {
                if (target < p) right = index - 1;
                else left = index + 1;
            }
        }
        return false;
    }
}
