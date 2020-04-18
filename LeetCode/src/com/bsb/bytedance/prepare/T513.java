package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-18 20:23
 */
public class T513 {

    // 二叉树最左下角节点
    int max = 0;
    int res = -1;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return res;
        helper(root, 1);
        return res;
    }

    private void helper(TreeNode root, int deep) {
        if (root == null) return;

        if (deep > max) {
            max = deep;
            res = root.val;
        }

        helper(root.left, deep + 1);
        helper(root.right, deep + 1);
    }
}
