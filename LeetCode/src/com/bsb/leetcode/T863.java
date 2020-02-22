package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 10:15
 */
public class T863 {


    // 二叉树中所有距离为k的节点
    // 返回距target节点k距离的所有节点值
    // 这题不能单纯看成是二叉树的dfs解
    // 因为距离target的距离为k的节点有可能是之前的pre节点 也有可能是以target节点为root的子树中的节点
    // 这里转换为图的思路去求解 这样就可以去掉二叉树那种dfs去搜
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer>[] graph = new ArrayList[1000];
        for (int i = 0; i < 1000; i++) {
            graph[i] = new ArrayList<>();
        }
        buildGraph(graph, root);
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[1000];
        List<Integer> res = new ArrayList<>();
        queue.add(new Integer[]{target.val, 0});
        visited[target.val] = true;
        while (queue.peek() != null) {
            Integer[] temp = queue.poll();
            if (temp[1] == K) {
                res.add(temp[0]);
                continue;
            }
            for (int child : graph[temp[0]]) {
                if (!visited[child]) {
                    queue.add(new Integer[]{child, temp[1] + 1});
                    visited[child] = true;
                }
            }
        }
        return res;
    }

    private void buildGraph(List<Integer>[] graph, TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            graph[node.val].add(node.left.val);
            graph[node.left.val].add(node.val);
            buildGraph(graph, node.left);
        }
        if (node.right != null) {
            graph[node.val].add(node.right.val);
            graph[node.right.val].add(node.val);
            buildGraph(graph, node.right);
        }
    }

}
