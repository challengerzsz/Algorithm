package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 21:04
 */
public class T783 {

    // BST节点最小距离
    // 返回任意两节点的最小差值
    // 这里其实可以思考
    // BST两节点之间的最小值可以通过中序遍历的方式进行计算
    private TreeNode pre;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode node) {
        if (node == null)
            return;

        helper(node.left);
        if (pre != null) {
            min = Math.min(min, node.val - pre.val);
        }
        pre = node;
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        new T783().minDiffInBST(root);
    }

}
