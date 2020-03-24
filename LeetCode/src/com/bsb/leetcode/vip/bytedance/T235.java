package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-24 21:31
 */
public class T235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int rootVal = root.val;
        int pV = p.val;
        int qV = q.val;


        if (pV > rootVal && qV > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pV < rootVal && qV < rootVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
