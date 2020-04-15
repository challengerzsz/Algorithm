package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-15 10:07
 */
public class T542 {

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 从左上角开始遍历，根据相邻左元素和上元素得出当前元素的对应结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    // 这里是期待通过状态转移来更新它
//                    matrix[i][j] = Integer.MAX_VALUE;
                    // 因为状态可能从这里转移到别的地方 如果是MAX_VALUE + 1就直接溢出了 row + col表示一个较大的数字就可以等待更新了
                    matrix[i][j] = row + col;
                }
                // 和上面的关系
                if (i > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                }
                // 和左边的关系
                if (j > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
                }
            }
        }
        // 第二次遍历，反向遍历，根据相邻右元素和下元素及当前元素的结果得出最终结果
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // 和下面的关系
                if (i < row - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                }
                // 和右边的关系
                if (j < col - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
                }
            }
        }
        return matrix;
    }
}
