package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 11:21
 */
public class T834 {

    // hard
    // 树中距离之和
    // 树中的元素从0 ～ n-1
    // 返回一个数组 数组中每个元素表示值为i的节点到所有节点的和
    // 第一种思路最简单 就是暴力从每个节点开始深搜 但是想也不用想 这hard的题O(n^2)的解肯定是超时的
    // 有点像最小生成树去环的思路 只不过这里去的不是环 去掉的是边
    // 假设两个节点x y直接连接 那么ans[x]的值应该是去掉x和y之间直接连接的边之后
    // x所在子树的所有节点到x的距离 + y所在子树的所有节点到y的距离 + x到y的距离
    private int[] res, count;
    private List<Set<Integer>> graph;
    private int N;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        graph = new ArrayList<>();
        res = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; ++i)
            graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int node, int parent) {
        for (int child : graph.get(node))
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
    }

    public void dfs2(int node, int parent) {
        for (int child : graph.get(node))
            if (child != parent) {
                res[child] = res[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
    }
}
