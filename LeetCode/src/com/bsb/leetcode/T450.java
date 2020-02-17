package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 21:15
 */
public class T450 {

    // 删除BST中的节点
    // 需要考虑的就是如何处理删除节点的左右子树 使其继续具有BST的性质
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // 从右子树中删除改节点
        if (key > root.val) root.right = deleteNode(root.right, key);
        // 从左子树中删除
        else if (key < root.val) root.left = deleteNode(root.left, key);
        // 找到了应该需要删除的节点
        else {
            // 如果当前需要被删除的节点是一个叶子结点 那就直接删掉就ok
            if (root.left == null && root.right == null) root = null;
            // 如果不是叶子结点且包含右子树
            else if (root.right != null) {
                // 从中序遍历的思路寻找该被删除节点的后继节点
                root.val = findSuccessor(root);
                // 因为这里直接把后继节点的值复制给了当前需要删除的节点 所以递归向下删除后继节点
                root.right = deleteNode(root.right, root.val);
            }
            // 如果不是叶子结点 并且有左子树
            else {
                // 找前驱节点
                root.val = findPredecessor(root);
                // 同理删除前驱节点
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int findSuccessor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    private int findPredecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }
}
