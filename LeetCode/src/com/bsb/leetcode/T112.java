package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-20 18:02
 */
public class T112 {

    boolean res = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res = true;
            }
        }

        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
