package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 21:15
 */
public class T938 {


    // 二叉搜索树的范围和
    // 返回值在[L, R]之间的所有节点和
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if (root.val >= L && root.val <= R) {
            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return rangeSumBST(root.right, L, R);
        }
    }
}
