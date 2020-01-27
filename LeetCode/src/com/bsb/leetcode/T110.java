package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 15:11
 */
public class T110 {


    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }

    // 自底向上 每个节点都会递归到以该节点为root的左右子树的叶子结点上去 从叶子结点开始
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1) res = false;
        return Math.max(left, right);
    }
}
