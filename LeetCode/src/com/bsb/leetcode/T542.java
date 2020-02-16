package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 21:21
 */
public class T542 {

    // 计算每个元素距最近的0的距离
    private int row;
    private int col;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * dp解 不需要利用额外数组 直接在当前矩阵上开始计算
     * dp[i][j]表示matrix[i][j]和最近的0的距离
     * 双向扫描 从左上开始 和从左下开始
     * 因为当前元素距0的距离是需要根据上下左右来计算的 所以两个方向互相填充
     */
    public int[][] updateMatrix1(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        // 从左上角开始遍历，根据相邻左元素和上元素得出当前元素的对应结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
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


    /**
     * bfs
     */
    public int[][] updateMatrix2(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = row + col;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            // 搜索上下左右四个方向
            for (int[] tempDirection : directions) {
                int i = temp[0] + tempDirection[0], j = temp[1] + tempDirection[1];
                // 边界
                if (i >= 0 && i < row && j >= 0 && j < col && matrix[i][j] > matrix[temp[0]][temp[1]] + 1) {
                    matrix[i][j] = matrix[temp[0]][temp[1]] + 1;
                    queue.add(new int[]{i, j});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] array = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        new T542().updateMatrix1(array);
    }
}
