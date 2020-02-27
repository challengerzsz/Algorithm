package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 21:13
 */
public class T785 {

    // 判断二分图
    // 给定一个无向图
    // 如果对任何一条边来说连接着的两个顶点可以划分到两个集合中 那么就是一个二分图
    // graph[i]表示顶点i能够到达的其余顶点
    private int[] colors;
    private boolean[] visited;

    // dfs + 着色
    // 如果标记这个节点为一个颜色 那么这个节点所有相连的所有其他节点都为另一个颜色
    public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        visited = new boolean[graph.length];
        // 对每一个顶点进行dfs 需要注意这个顶点在之前的dfs时有没有被遍历过
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!dfs(i, 0, graph)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int index, int color, int[][] graph) {
        visited[index] = true;
        // 标记当前顶点为color
        colors[index] = color;
        for (int temp : graph[index]) {
            // 如果没有访问过并且这个邻接顶点和当前顶点一个颜色 那么说明这个图划分不出来两种集合
            if (!visited[temp]) {
                // 标记与当前顶点相连的其他顶点为另一个颜色
                if (!dfs(temp, 1 - color, graph)) return false;
            } else if (colors[index] == colors[temp]) return false;
        }
        return true;
    }
}
