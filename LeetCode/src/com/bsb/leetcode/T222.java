package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-23 17:46
 */
public class T222 {

    int res = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return res;
        help(root);
        return res;
    }

    private void help(TreeNode root) {
        if (root == null) return;
        res++;
        help(root.left);
        help(root.right);
    }
}
