package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 20:55
 */
public class T701 {

    // BST插入操作
    // 把新加入的节点作为叶子结点插入BST
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);
        return root;
    }
}
