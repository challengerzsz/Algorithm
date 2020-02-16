package com.bsb.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 16:10
 */
public class T407 {

    // 接雨水2
    // 二维高度矩阵 计算能接的雨水是多少
    class HelperStruct {
        int x;
        int y;
        int h;

        public HelperStruct(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    // 木桶效应 从最外圈开始收缩
    // 根据木桶效应缩小范围 最后就是能装水的结果
    public int trapRainWater(int[][] heightMap) {
        // 利用小顶堆 加快查询最小的速度
        PriorityQueue<HelperStruct> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.h));

        // 两行或两列装不了水
        if (heightMap.length < 3 || heightMap[0].length < 3) return 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        // dp数组在这里其实只是起到标记作用 标记
        int[][] dp = new int[row][col];
        // 填充第一列和最后一列的dp数组 其实就是最外圈的高度 并且封装HelperStruct 放入小顶堆
        for (int i = 0; i < row; i++) {
            heap.offer(new HelperStruct(i, 0, heightMap[i][0]));
            dp[i][0] = 1;
            heap.offer(new HelperStruct(i, col - 1, heightMap[i][col - 1]));
            dp[i][col - 1] = 1;
        }
        // 填充第一行和最后一行
        for (int i = 1; i < col - 1; i++) {
            heap.offer(new HelperStruct(0, i, heightMap[0][i]));
            dp[0][i] = 1;
            heap.offer(new HelperStruct(row - 1, i, heightMap[row - 1][i]));
            dp[row - 1][i] = 1;
        }
        
        final int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        int res = 0;
        // 因为此时堆里只是最外圈的HelperStruct 所以从heap中poll最低点 然后向内进行缩小
        while (!heap.isEmpty()) {
            HelperStruct t = heap.poll();
            int x = t.x;
            int y = t.y;
            int h = t.h;
            for (int[] ints : directions) {
                int nextX = x + ints[0];
                int nextY = y + ints[1];
                // 边界判断 这里其实就是bfs的思路
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || dp[nextX][nextY] == 1)
                    continue;
                // 统计能装水的数量
                if (h > heightMap[nextX][nextY]) {
                    res += h - heightMap[nextX][nextY];
                    heightMap[nextX][nextY] = h;
                }
                heap.add(new HelperStruct(nextX, nextY, heightMap[nextX][nextY]));
                // 修改dp数组的标记
                dp[nextX][nextY] = 1;
            }
        }
        return res;

    }
}
