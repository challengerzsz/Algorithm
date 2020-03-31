package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-31 20:08
 */
public class T240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int minLength = Math.min(matrix.length, matrix[0].length);
        // 遍历对角线 再二分
        for (int i = 0; i < minLength; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int low = start;
        int high = vertical ? matrix[0].length - 1 : matrix.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (vertical) {
                if (matrix[start][mid] < target) {
                    low = mid + 1;
                } else if (matrix[start][mid] > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[mid][start] < target) {
                    low = mid + 1;
                } else if (matrix[mid][start] > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    // 左下角线性搜索
    public boolean searchMatrix2(int[][] matrix, int target) {

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }


}
