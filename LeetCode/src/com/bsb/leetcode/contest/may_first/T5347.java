package com.bsb.leetcode.contest.may_first;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 11:11
 */
public class T5347 {

    //                                      右       左       下       上
    private int[][] directions = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int[][] matrix = new int[grid.length][grid[0].length];
        for (int[] temp : matrix) Arrays.fill(temp, Integer.MAX_VALUE);

        queue.offer(new int[]{0, 0});
        matrix[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 1; i < directions.length; i++) {
                int m = temp[0] + directions[i][0];
                int n = temp[1] + directions[i][1];
                if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length) continue;

                if (i == grid[temp[0]][temp[1]]) {
                    if (matrix[m][n] > matrix[temp[0]][temp[1]]) {
                        queue.offer(new int[]{m, n});
                        matrix[m][n] = matrix[temp[0]][temp[1]];
                    }
                } else {
                    if (matrix[m][n] > matrix[temp[0]][temp[1]] + 1) {
                        queue.offer(new int[]{m, n});
                        matrix[m][n] = matrix[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }

        return matrix[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}};
        new T5347().minCost(grid);
    }

}
