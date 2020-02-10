package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 21:21
 */
public class T129 {

    // 根节点到叶子节点求和
    // 这题虽然是深搜类型的 但是注意观察就能观察到是一棵完全二叉树 因为局限于题目的输入格式..
    // 直接利用完全二叉树 对于某一个节点来说 左右子树 = 2 * index + 1 || 2 * index + 2
    // 没想到题目直接给的是个TreeNode 刚才那种思路还验证了一下 看来是不行了
    // 那就dfs吧
    public int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String str) {
        if (root.left == null && root.right == null) {
            str += root.val;
            res += Integer.parseInt(str);
            return;
        }
        if (root.left != null) dfs(root.left, str + root.val);
        if (root.right != null) dfs(root.right, str + root.val);
    }
}
