package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-02 12:15
 */
public class T778 {

    // 水位上升的泳池中游泳
    // 从[0, 0]开始 可以随时向上下左右游
    // 前提是当前所在的格子和即将游向的格子同样高 或者是水位高度达到另一个平台的高度
    // grid每个元素表示泳池的高度
    // 每经过t时间会升高t高度的水位

    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        // 寻找整个矩阵中的最大最小值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(grid[i][j], max);
                min = Math.min(grid[i][j], min);
            }
        }

        int start = min;
        int end = max;

        Queue<int[]> queue = new LinkedList<>();
        // 二分搜一个处于min ～ max中的值 bfs判断是不是能够能从[0, 0] 找到一条路径能够满足所有的平台高度小于这个值
        while (start < end) {
            int mid = (start + end) / 2;
            if (grid[0][0] > mid) {
                start = mid + 1;
                continue;
            }

            queue.offer(new int[]{0, 0});
            boolean flag = false;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] index = queue.poll();
                    // 到达右下角 flag 置 true
                    if (index[0] == grid.length - 1 && index[1] == grid[0].length - 1) {
                        flag = true;
                        break;
                    }
                    for (int[] temp : directions) {
                        int x = temp[0] + index[0];
                        int y = temp[1] + index[1];

                        // 边界在矩阵之内 继续bfs
                        // 未访问过 且这个mid这个高度大于广搜路径上的高度
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                                && !visited[x][y] && grid[x][y] <= mid) {
                            queue.offer(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }

            }
            if (flag) {
                end = mid;
            } else {
                start = mid + 1;
            }
            queue.clear();

        }
        return start;
    }

}
