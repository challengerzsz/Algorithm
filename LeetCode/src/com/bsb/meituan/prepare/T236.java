package com.bsb.meituan.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-24 21:17
 */
public class T236 {

    // 二叉树最近公共祖先
    // 非BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
