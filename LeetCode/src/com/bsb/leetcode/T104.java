package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 12:10
 */
public class T104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 0);
    }

    private int helper(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int max = Math.max(helper(root.left, level + 1), helper(root.right, level + 1));
        return max;
    }
}
