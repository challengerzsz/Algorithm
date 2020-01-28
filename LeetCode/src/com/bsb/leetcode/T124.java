package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 11:40
 */
public class T124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(left + right + root.val, res);
        return Math.max(0, Math.max(left, right) + root.val);
    }
}
