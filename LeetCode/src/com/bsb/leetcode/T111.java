package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 15:33
 */
public class T111 {

    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        return Math.min(helper(root.left), helper(root.right)) + 1;
    }


    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null)
            return Math.max(minDepth2(root.left), minDepth2(root.right)) + 1;
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }
}
