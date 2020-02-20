package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 16:51
 */
public class T684 {

    // 冗余连接
    // 给出的其实是一个无向无环图 给定的二维数组是一个图中所有相关点之间的边的集合
    // 删除一边 满足图中没有环的出现
    // 可能有多个解 返回edges中最后出现的边(需要被删除的边)
    // dfs
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // 相当于邻接矩阵
        List<Integer>[] listArray = new ArrayList[n + 1];
        // 初始化listArray
        for (int i = 0; i < n + 1; i++) {
            listArray[i] = new ArrayList<>();
        }
        // 完善邻接矩阵
        for (int[] nums : edges) {
            // 因为是无向图 所以正反都需要添加
            listArray[nums[0]].add(nums[1]);
            listArray[nums[1]].add(nums[0]);
        }
        // 访问数组
        boolean[] visited = new boolean[n + 1];
        // 从后向前dfs 因为如果出现可以删除的边 题目要求是出现较后的边
        // 思路其实就是从某一条边开始dfs 如果一趟dfs之后还是存在节点没有访问到 那就说明这条边就是多余的那条边
        for (int i = edges.length - 1; i >= 0; i--) {
            dfs(edges[i][0], visited, edges[i][1], listArray);
            boolean flag = true;
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j]) {
                    flag = false;
                    break;
                }
            }
            // 找到了应该删除的边
            if (flag) return new int[]{edges[i][0], edges[i][1]};
            // 每一趟dfs都是不同的边 所以如果这一趟完成之后要用false填充整个访问数组
            Arrays.fill(visited, false);
        }
        return new int[]{0, 0};
    }

    public void dfs(int node1, boolean[] visited, int node2, List<Integer>[] listArray) {
        visited[node1] = true;
        // 找邻接矩阵 继续dfs
        for (int next : listArray[node1]) {
            if (next == node2) continue;
            // 这里把node2置为-1的原因是因为需要对node2的所有邻接节点进行dfs 所以不能满足上面的一个if
            if (!visited[next]) dfs(next, visited, -1, listArray);
        }
    }
    // 这题目的基本上所有题解都是围绕并查集这个概念展开的 并查集这个还没有看过 需要去看看
}
