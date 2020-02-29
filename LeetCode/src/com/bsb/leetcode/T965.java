package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-29 10:07
 */
public class T965 {

    // 单值二叉树
    private int one;

    public boolean isUnivalTree(TreeNode root) {
        one = root.val;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {

        if (root == null) return true;
        if (root.val != one) return false;

        return dfs(root.left) && dfs(root.right);
    }
}
