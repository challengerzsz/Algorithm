package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-30 21:49
 */
public class T112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum) || helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }

        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
