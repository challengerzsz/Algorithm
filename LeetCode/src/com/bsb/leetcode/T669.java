package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 16:14
 */
public class T669 {

    // 修剪二叉树
    // 修剪二叉树直到root中只保留[L, R]的节点
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        // 删除不满足要求的节点
        // 返回修剪过的右子树 递归进行
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        // 修剪树
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
