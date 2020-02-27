package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 21:45
 */
public class T802 {

    // 找到最终的安全状态
    // 102 / 111 超时
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!dfs(graph, i, visited)) ans.add(i);
            // 这里是对每个顶点都是可以作为起点 需要重置visited数组
            Arrays.fill(visited, false);
        }
        return ans;
    }

    private boolean dfs(int[][] graph, int start, boolean[] visited) {
        if (visited[start]) return true;
        visited[start] = true;
        for (int next : graph[start]) {
            if (dfs(graph, next, visited)) return true;
        }
        // 回溯
        visited[start] = false;
        return false;
    }


    // 拓扑排序
    // 拓扑排序其实本该是从图中一步一步去掉入度为0的顶点
    // 但是这个题目的题意要求我们完成逆拓扑排序
    public static List<Integer> eventualSafeNodes2(int[][] graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        // 反向图
        // 原先graph[i]表示顶点i能够到达其他的顶点是什么
        // 现在根据graph创建reversGraph表示顶点i都有哪些入边 也就是都有哪些节点能够直接指向顶点i
        ArrayList<ArrayList<Integer>> reversGraph = new ArrayList<>();
        int n = graph.length;
        // 出度
        int[] out = new int[n];
        for (int i = 0; i < n; i++) reversGraph.add(new ArrayList<>());

        for (int i = 0; i < graph.length; i++) {
            // 计算顶点i的出度
            out[i] += graph[i].length;
            // 如果顶点i的出度为0 那么就入队
            // 拓扑排序的核心就是queue和入度 || 出度
            if (out[i] == 0) queue.add(i);
            // 计算reversGraph
            for (int j = 0; j < graph[i].length; j++) {
                reversGraph.get(graph[i][j]).add(i);
            }
        }

        while (!queue.isEmpty()) {
            int index = queue.get(0);
            queue.remove(0);

            // 减掉出度 再次入队
            for (int i : reversGraph.get(index)) {
                if (--out[i] == 0) queue.add(i);
            }
        }

        for (int i = 0; i < out.length; i++) {
            if (out[i] == 0) res.add(i);
        }
        return res;
    }
}
