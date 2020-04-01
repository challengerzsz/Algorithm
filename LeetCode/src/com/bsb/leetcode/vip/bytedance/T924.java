package com.bsb.leetcode.vip.bytedance;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-01 19:41
 */
public class T924 {

    // 减少恶意软件传播
    // dfs + 着色
    public int minMalwareSpread(int[][] graph, int[] initial) {
        if (graph == null || graph.length == 0) return -1;

        // 每个顶点的颜色
        int[] everyNodeColor = new int[graph.length];
        Arrays.fill(everyNodeColor, -1);

        int color = 0;
        for (int i = 0; i < graph.length; i++) {
            if (everyNodeColor[i] == -1) dfs(graph, i, everyNodeColor, color++);
        }

        // 每种颜色的顶点数量
        // 其实每种颜色就是一个连通分量 这个数组的意思就是每个连通分量的顶点数量是多少
        int[] everyColorCount = new int[color];
        for (int i = 0; i < everyNodeColor.length; i++) {
            everyColorCount[everyNodeColor[i]]++;
        }

        // 统计和恶意节点颜色一样的数量
        // 也就是统计一个连同分量中是否存在多个恶意节点
        int[] badNodeColors = new int[color];
        for (int node : initial) {
            badNodeColors[everyNodeColor[node]]++;
        }


        int res = Integer.MAX_VALUE;
        for (int node : initial) {
            int badNodeColor = everyNodeColor[node];

            if (badNodeColors[badNodeColor] == 1) {
                if (res == Integer.MAX_VALUE) {
                    res = node;
                } else if (everyColorCount[badNodeColor] > everyColorCount[everyNodeColor[res]]) {
                    res = node;
                } else if (everyColorCount[badNodeColor] == everyColorCount[everyNodeColor[res]] && node < res) {
                    res = node;
                }
            }
        }

        if (res == Integer.MAX_VALUE) {
            // 恶意节点并不是按照升序给的
//            return initial[0];
            for (int temp : initial) {
                res = Math.min(res, temp);

            }
        }

        return res;
    }

    private void dfs(int[][] graph, int index, int[] everyNodeColor, int color) {

        everyNodeColor[index] = color;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1 && everyNodeColor[i] == -1) {
                dfs(graph, i, everyNodeColor, color);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 0, 0, 0, 1}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, {0, 1, 1, 1, 1, 0, 1, 0, 0, 1}};
        int[] badNode = new int[]{9, 0, 2};

        new T924().minMalwareSpread(graph, badNode);
    }
}
