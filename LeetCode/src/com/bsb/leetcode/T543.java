package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 16:26
 */
public class T543 {

    // 二叉树的直径
    // 二叉树的直径是任意两个节点之间的距离最大值
    // 思考了一下其实就是左右两个子树的最大深度和
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        helper(root);
        return res - 1;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        res = Math.max(res, left + right + 1);
        // 返回的值应该是以当前node为root 左右子树最深的和 + 1包括自己
        return Math.max(left, right) + 1;
    }


}
