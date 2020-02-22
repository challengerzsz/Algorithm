package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 11:01
 */
public class T814 {

    // 二叉树剪枝 二叉树中只有1和0
    // 删除所有不包含1的子树
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
