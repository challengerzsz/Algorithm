package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 10:38
 */
public class T994 {


    // 腐烂的橘子
    // 没有橘子 0
    // 好橘子 1
    // 坏橘子 2
    // 坏橘子向四个正向传播
    // 所有的好橘子都坏了的最少传播次数
    // 如果最后还会有橘子剩余 那么返回-1
    // bfs
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> timeMap = new HashMap<>();

        // 这里一下把所有的一开始就是坏的橘子直接丢进queue
        // 如果不这么做 就需要对每次一开始就是坏橘子的点进行一次bfs 编码有点费劲 刚开始的思路就是这样
        // 还得区分什么是被传播的橘子什么是一开始就是坏的橘子
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    int target = i * grid[0].length + j;
                    queue.add(target);
                    timeMap.put(target, 0);
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int target = queue.remove();
            int i = target / grid[0].length, j = target % grid[0].length;

            for (int[] temp : directions) {
                int x = temp[0] + i;
                int y = temp[1] + j;
                if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    int next = x * grid[0].length + y;
                    queue.add(next);
                    // timeMap 保存的是某个被传播的节点 传播到它的时候所需的次数
                    timeMap.put(next, timeMap.get(target) + 1);
                    res = timeMap.get(next);
                }
            }
        }

        // 是否所有橘子都坏了
        for (int[] row: grid) {
            for (int temp: row) {
                if (temp == 1)
                    return -1;
            }
        }

        return res;
    }
}
