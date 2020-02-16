package com.bsb.leetcode.contest.seventeenth;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 10:33
 */
public class T1 {

    // 矩阵每一行都是非递增数据
    // 统计矩阵中负数的个数
    public int countNegatives(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) res++;
                else break;
            }
        }
        return res;
    }
}
