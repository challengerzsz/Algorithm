package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 12:19
 */
public class T530 {

    // 二叉树中任意两节点的差的绝对值最小值
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    // 时间击败18%
    private void dfs(TreeNode root) {
        if (root == null) return;
        counterHelper(root, root);
        dfs(root.left);
        dfs(root.right);
    }

    private void counterHelper(TreeNode root, TreeNode rootRoot) {
        if (root == null) return;
        if (root != rootRoot) {
            min = Math.min(min, Math.abs(root.val - rootRoot.val));
        }
        counterHelper(root.left, rootRoot);
        counterHelper(root.right, rootRoot);
    }


    // 仔细看了一下题目是BST
    // 如果思考之后可以得到这个结论 对于任何一个节点 绝对值最小只能存在与该节点和左右子节点之间
    public TreeNode pre = null;
    // 100%
    public int getMinimumDifference2(TreeNode root) {
        counterHelper(root);
        return min;
    }

    private void counterHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        counterHelper(root.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(root.val - pre.val));
        }
        pre = root;
        counterHelper(root.right);
    }
}
