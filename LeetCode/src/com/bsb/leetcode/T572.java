package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 17:52
 */
public class T572 {

    // 另一棵子树是不是s的子结构
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (t == null) return true;
        if (s == null) return false;

        if (s.val != t.val) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return checkHelper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }
    
    private boolean checkHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return checkHelper(root1.left, root2.left) && checkHelper(root1.right, root2.right);
    }
}
