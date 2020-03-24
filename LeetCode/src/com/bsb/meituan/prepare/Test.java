package com.bsb.meituan.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-24 22:05
 */
public class Test {

    static void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);
        System.out.println(root.val);
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.right = new TreeNode(6);
        root.left.right.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(8);

        helper(root);
    }
}
