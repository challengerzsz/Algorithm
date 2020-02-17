package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 20:42
 */
public class T404 {

    // 左叶子节点的和
    private int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int flag) {
        if (root == null) return;
        if (flag == -1 && root.left == null && root.right == null) {
            res += root.val;
        }
        helper(root.left, -1);
        helper(root.right, 1);
    }
}
