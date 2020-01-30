package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 21:20
 */
public class T304 {

    static int[][] array = new int[1000][1000];

    // 暴力解 超时 原因是这个方法会被调用很多次
//    public T304(int[][] matrix) {
//        array = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int r = row1; r <= row2; r++) {
//            for (int c = col1; c <= col2; c++) {
//                sum += array[r][c];
//            }
//        }
//        return sum;
//    }

    public T304(int[][] matrix) {
        if (matrix.length > 0) {
            for (int i = 0; i < matrix.length; i++) {
                int sum = 0;
                for (int j = 1; j <= matrix[0].length; j++) {

                    // array数组表示的是每一行的每一位都是前面几个元素求和
                    sum += matrix[i][j - 1];
                    array[i][j] = sum;
                }
            }
        }
    }

    // 计算((row1, col1) -> (row2, col2)) 包围的矩阵元素总和
    // 这个方法可能会被调用很多次
    // 这个方法先求和 对每一个array数组中的元素都是该元素位置前本行的元素和
    // 所以只需要求和的时候减去每一行的col1之前的和即可
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += array[i][col2 + 1] - array[i][col1];
        }
        return sum;
    }
}
