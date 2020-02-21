package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 20:51
 */
public class T700 {

    // 二叉树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
