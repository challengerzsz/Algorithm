package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-12 10:59
 */
public class T417 {

    // 太平洋大西洋水流问题
    // 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动
    // 做完dfs之后还想取取巧试试 看着BFS好像能找出一些规律 广搜的时候同样按照逆流的思路寻找
    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        // 两个同等大小的二维数组
        // visited1表示这个位置的水能不能流入大西洋
        // visited2表示这个位置的水能不能流入太平洋
        boolean[][] visited1 = new boolean[row][col], visited2 = new boolean[row][col];

        // dfs的思路其实有点像逆流而上
        // 从那些能够流入大西洋或者太平洋的点开始逆流找 找到的点对应就能流入大西洋或者太平洋
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    //
                    dfs(matrix, visited1, i, j, matrix[i][j]);
                }
                if (i == row - 1 || j == col - 1) {
                    dfs(matrix, visited2, i, j, matrix[i][j]);
                }

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 取大西洋和太平洋都能够到达的点添加结果集
                if (visited1[i][j] && visited2[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int last) {
        // dfs无越界 并且该点未访问到 并且该点水流大小小于上个水流大小
        // 很通俗的说就是根据题意要求的直接dfs模拟水流的方向
        if (checkIfInArea(matrix, i, j) && !visited[i][j] && matrix[i][j] >= last) {
            visited[i][j] = true;
            for (int[] temp : directions) {
                dfs(matrix, visited, i + temp[0], j + temp[1], matrix[i][j]);
            }
        }

    }

    private boolean checkIfInArea(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
