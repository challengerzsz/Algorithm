package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 21:22
 */
public class T980 {

    // 不同的路径
    // 矩阵中包含几种状态
    // 1 起点 2 终点 0 可以走的格子 -1 障碍
    // 可以走的格子必须都走完
    // 求不同的路径数量
    public int uniquePathsIII(int[][] grid) {
        // 无障碍格子和起始点的个数求和
        int sum = 1;
        int startI = 0;
        int startJ = 0;

        // 扫描起点的同时统计能够走的无障碍格子数量
        // dfs需要sum去做判断是不是所有无障碍格子都走过了
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    sum++;
                } else if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }
        return dfs(grid, startI, startJ, sum);
    }


    public int dfs(int[][] g, int i, int j, int sum) {
        // 越界判断
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == -1) {
            return 0;
        }

        // dfs到终点的时候需要判断是不是走完了所有的无障碍点
        if (g[i][j] == 2) return 0 == sum ? 1 : 0;
        int res = 0;
        // 这里还是跟岛屿问题一样 其实是通常的dfs的思路 为了避免重复走
        g[i][j] = -1;
        res += dfs(g, i + 1, j, sum - 1);
        res += dfs(g, i - 1, j, sum - 1);
        res += dfs(g, i, j + 1, sum - 1);
        res += dfs(g, i, j - 1, sum - 1);
        // 回溯需要撤销当前选择
        g[i][j] = 0;
        return res;
    }
}
