package com.bsb.sword;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-03-31 17:15
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class SubTree {


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        boolean result = false;
        if (root1.val == root2.val) {
            result = ifContains(root1, root2);
        }

        if (!result) {
            result = ifContains(root1.left, root2);
        }
        if (!result) {
            result = ifContains(root1.right, root2);
        }

        return result;

    }

    public boolean ifContains(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return ifContains(root1.left, root2.left) && ifContains(root1.right, root2.right);
    }

}
