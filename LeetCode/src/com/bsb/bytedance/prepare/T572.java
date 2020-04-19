package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-19 20:22
 */
public class T572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (s.val == t.val) {
            return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s != null && t == null) return false;
        if (s == null && t != null) return false;
        if (t == null) return true;
        if (s.val != t.val) return false;

        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
