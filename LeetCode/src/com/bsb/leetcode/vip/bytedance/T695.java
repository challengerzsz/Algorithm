package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-15 22:12
 */
public class T695 {

    // 岛屿最大面积
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int area;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = helper(grid, i, j);
                    max = area > max ? area : max;
                }
            }
        }
        return max;
    }

    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int area = 1;
        for (int d = 0; d < directions.length; d++) {
            area += helper(grid, i + directions[d][0], j + directions[d][1]);
        }
        // 之前在这里做了回溯之后撤销对当前这个元素做的修改
        // 但是没有通过 因为这里其实并不需要回溯修改为原来的值
        // 因为再次从这个节点dfs的结果肯定和能够到达这里的起点获得的值一样
        // grid[i][j] = 1;
        return area;
    }
}
