package com.bsb.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-29 21:33
 */
public class T1162 {

    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int check = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                check += grid[i][j];
            }
        }
        // 全海洋或全陆地的情况
        if (check == 0 || check == grid.length * grid[0].length) return -1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // BFS
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 从各个陆地开始，最后遍历到的海洋就是离陆地最远的海洋
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 这里再次入队的都是海洋区域 陆地不再入队
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                // 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：
                // (x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1|
                // 题目要求曼哈顿距离 其实可以理解为 如果当前区域是一个陆地 上下左右区域的曼哈顿距离为1
                // 所以在这里做个操作 每次bfs到一个海洋就给这个海洋区域在数组中的位置赋值为能bfs到他的区域的值 + 1
                // 这样就能够保证是从某个陆地开始到这个节点的距离
                grid[newX][newY] = grid[x][y] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
        // 返回最后一次遍历到的海洋的距离
        return grid[point[0]][point[1]] - 1;
    }
}
