package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 16:48
 */
public class T563 {

    // 二叉树的坡度
    // 二叉树的坡度定义为对于每个节点来说 左子树和右子树节点和的绝对值的和
    private int res = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        new T563().findTilt(root);
    }
}
