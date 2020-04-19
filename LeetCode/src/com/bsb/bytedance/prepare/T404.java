package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-19 19:49
 */
public class T404 {

    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        if (root.left != null && root.left.left == null && root.left.right == null) res += root.left.val;

        helper(root.left);
        helper(root.right);
    }
}
