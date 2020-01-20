package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-20 16:40
 */
public class T100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}
