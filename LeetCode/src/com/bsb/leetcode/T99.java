package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-04 17:35
 */
public class T99 {

    // 标记两个不在自己位置的节点
    private TreeNode target1 = null;
    private TreeNode target2 = null;
    private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    // 中序遍历BST判断顺序 并且交换
    // 交换val
    public void recoverTree(TreeNode root) {
        in_order(root);
        int tmp = target1.val;
        target1.val = target2.val;
        target2.val = tmp;
    }

    private void in_order(TreeNode root) {
        if (root == null) return;
        in_order(root.left);
        if (target1 == null && preNode.val > root.val) target1 = preNode;
        if (target1 != null && preNode.val > root.val) target2 = root;
        preNode = root;
        in_order(root.right);
    }
}
