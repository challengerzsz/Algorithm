package com.bsb.leetcode.contest.twenty_first_double;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 22:00
 */
public class T5338 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 二叉树中最长交错路径
    public int longestZigZag(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp);
                if (temp != null) {
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) == null) continue;
            boolean flag = true;
            TreeNode temp = list.get(i);
            int count = 0;
            int index = i;
            while (temp != null) {
                count++;
                // 先向左
                if (flag) {
                    index = 2 * index + 1;
                    if (index >= list.size()) break;
                    temp = list.get(index);
                    flag = !flag;
                } else {
                    index = 2 * index + 2;
                    if (index >= list.size()) break;
                    temp = list.get(index);
                    flag = !flag;
                }
            }
            max = Math.max(count, max);
            count = 0;
            flag = false;
            temp = list.get(i);
            index = i;
            while (temp != null) {
                count++;
                // 先向左
                if (flag) {
                    index = 2 * index + 2;
                    if (index >= list.size()) break;
                    temp = list.get(index);
                    flag = !flag;
                } else {
                    index = 2 * index + 1;
                    if (index >= list.size()) break;
                    temp = list.get(index);
                    flag = !flag;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    private int max = 0;

    public int longestZigZag2(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private void dfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        helper(root, true, -1);
        helper(root, false, -1);
        dfs(root.left);
        dfs(root.right);
    }

    private void helper(TreeNode root, boolean flag, int level) {

        if (root == null) {
            max = Math.max(max, level);
            return;
        }
        if (flag) {
            helper(root.left, !flag, level + 1);
        } else {
            helper(root.right, !flag, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.right = new TreeNode(6);
        new T5338().longestZigZag(root);
    }
}
