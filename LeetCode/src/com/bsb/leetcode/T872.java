package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 16:47
 */
public class T872 {

    // 叶子相似的树
    // 叶子相似的意思是 如果两颗二叉树具有同样的叶子结点 那么就说明这两颗二叉树是叶相等的二叉树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 思路dfs两次二叉树 统计两棵树的叶子结点 然后做对比
        StringBuilder leafStr1 = new StringBuilder();
        StringBuilder leafStr2 = new StringBuilder();
        dfs(root1, leafStr1);
        dfs(root2, leafStr2);
        return leafStr1.toString().equals(leafStr2.toString());
    }

    private void dfs(TreeNode root, StringBuilder leafStr) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafStr.append(root.val);
            return;
        }

        dfs(root.left, leafStr);
        dfs(root.right, leafStr);
    }
}
