package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 20:47
 */
public class T437 {

    // 路径总和
    // 可以不经过root 但是方向必须是向下
    int res = 0;
    // pathSum即作为lc的调用入口 同时也以先序遍历的形式从每个节点开始dfs
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    // helper是真正dfs寻路的
    public void helper(TreeNode root, int sum) {
        if (root == null) return;
        if (sum < 0) return;
        sum -= root.val;
        if (sum == 0) {
            res++;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
