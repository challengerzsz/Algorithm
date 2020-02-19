package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 21:32
 */
public class T623 {

    // 在第d行新增一行值为v的节点
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        helper(root, v, d, 1);
        return root;
    }

    private void helper(TreeNode root, int v, int d, int deep) {
        if (deep > d - 1) return;
        if (root == null) return;
        if (deep == d - 1) {
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }
        helper(root.left, v, d, deep + 1);
        helper(root.right, v, d, deep + 1);
    }
}
