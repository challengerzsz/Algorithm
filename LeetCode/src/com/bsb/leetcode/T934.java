package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-28 19:38
 */
public class T934 {

    // 最短的桥
    // 一共两个岛
    // 连接两个岛需要最短的桥是多少
    // dfs + bfs 深搜其中一个岛 从这个岛的外边界开始广搜 直到碰到另一个岛
    private Queue<int[]> queue;
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] A) {
        if (A.length == 0) return -1;
        queue = new LinkedList<>();

        // 深搜其中一个岛
        firstLoop:
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(i, j, A);
                    break firstLoop;
                }
            }
        }

        while (true) {
            // 如果队列为空则证明用例无解
            if (queue.isEmpty()) return -1;

            int[] curArray = queue.poll();
            int i = curArray[0];
            int j = curArray[1];

            for (int k = 0; k < 4; k++) {
                int x = i + directions[k][0];
                int y = j + directions[k][1];
                if (x < 0 || y < 0 || x >= A.length || y >= A.length) continue;
                // 如果碰到了第二个岛 返回
                // 因为是广搜的 所以一旦搜到另一个岛就证明是一个最小桥数量
                if (A[x][y] == 1) {
                    return A[i][j] - 1;
                }
                if (A[x][y] == 0) {
                    A[x][y] = A[i][j] + 1;
                    // 将bfs的新边界入队 下一次从这个最新边界开始bfs
                    queue.add(new int[]{x, y});
                }
            }
        }

    }

    private void dfs(int i, int j, int[][] A) {
        // 这里走过的第一个岛全部用-1替代
        A[i][j] = -1;
        for (int index = 0; index < 4; index++) {
            int x = i + directions[index][0];
            int y = j + directions[index][1];
            // 边界判断
            if (x < 0 || y < 0 || x >= A.length || y >= A[0].length) continue;
            // 岛屿外圈元素 赋值为2 然后入队
            if (A[x][y] == 0) {
                // 这里标记为2的目的是一个是为了表示这个是边界 第二是因为如果标记为1的话 广搜的时候没办法和另一个岛区分
                A[x][y] = 2;
                queue.add(new int[]{x, y});
            } else if (A[x][y] == 1) dfs(x, y, A); // 继续搜这个岛
        }
    }
}
