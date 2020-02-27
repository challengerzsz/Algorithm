package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 19:25
 */
public class T1219 {

    // 黄金矿工
    // 能从矩阵任何一个不为0的点开始挖
    // 一开始想的是dfs + 贪心 (错误)
    // 但是想了一下 dfs的时候贪心挖最大的矿 如果以这个思路出发 就需要一开始统计最大矿的位置
    // 但是最大矿的位置只是当前最优 每次都去贪心当前最优 但是有可能不能实现全局最优 所以这里贪心思路不适用
    // 深搜
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 边界以及不能挖矿判断
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // 回溯保存当前值
        // 修改为0 为了之后调用的dfs不再重复挖矿
        int temp = grid[i][j];
        grid[i][j] = 0;

        int up = dfs(grid, i + 1, j);
        int down = dfs(grid, i - 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);

        // 回溯
        grid[i][j] = temp;

        return Math.max(Math.max(up, down), Math.max(left, right)) + temp;
    }
}
