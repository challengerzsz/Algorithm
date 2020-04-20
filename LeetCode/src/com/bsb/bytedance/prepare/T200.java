package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-20 09:49
 */
public class T200 {

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 岛屿数量
    int res = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] temp : directions) {
            int x = i + temp[0];
            int y = j + temp[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != '0') {
                dfs(grid, x, y);
            }
        }
    }
}
