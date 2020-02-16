package com.bsb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 19:44
 */
public class T513 {

    // 找到二叉树最后一层的最左节点是什么
    // 这题被归到BFS的范围
    // 其实先序遍历的dfs依旧可以求解
    // 81%
    private int res = 0;
    private int maxDeep = 0;
    public int findBottomLeftValue(TreeNode root) {

        helper(root, 1);
        return res;
    }

    // dfs在这里没有办法选择剪枝条件 也就是说会按照先序序列全部递归出来
    private void helper(TreeNode root, int deep) {
        if (root == null) return;
        if (deep > maxDeep) {
            res = root.val;
            maxDeep = deep;
        }
        helper(root.left, deep + 1);
        helper(root.right, deep + 1);
    }

    // bfs 5.88%
    private int findBottomLeftValueBFS(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Deque<TreeNode> nextDeepQueue = new LinkedList<>();
            TreeNode mayBeAns = queue.getFirst();
            int len = queue.size();
            for (int i = 1; i <= len; i++) {
                TreeNode temp = queue.pollFirst();
                if (temp.left != null) nextDeepQueue.addLast(temp.left);
                if (temp.right != null) nextDeepQueue.addLast(temp.right);
            }
            if (nextDeepQueue.size() == 0) {
                res = mayBeAns.val;
                break;
            }
            queue.addAll(nextDeepQueue);
        }
        return res;
    }
}
