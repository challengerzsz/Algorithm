package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 21:12
 */
public class T200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                // dfs的起点是岛屿代表的1
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 岛屿这题就是从1开始dfs搜所有的1
    // 把所有与搜索起点相连的1先换成别的字符 保证别的1为起点的时候不会重复搜索
    // 深搜就完了
    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }


        // 从某岛屿的某一个起点dfs之后置为0
        // 避免外层又以该点为新岛屿的起点计数
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
