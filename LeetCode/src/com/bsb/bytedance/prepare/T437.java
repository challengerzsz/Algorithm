package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-19 19:55
 */
public class T437 {

    // 路径总和
    // 方向向下
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;

        helper(root, sum, 0);
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    private void helper(TreeNode root, int sum, int cur) {
        if (root == null) return;

        if (cur + root.val == sum) res++;
        helper(root.left, sum, cur + root.val);
        helper(root.right, sum, cur + root.val);
    }
}
