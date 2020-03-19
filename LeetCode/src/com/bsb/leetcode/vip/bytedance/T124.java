package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 10:45
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class T124 {

    // 二叉树中最大路径和
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, left + right + root.val);

        return Math.max(0, Math.max(left, right) + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-3);
        new T124().maxPathSum(root);
    }
}
