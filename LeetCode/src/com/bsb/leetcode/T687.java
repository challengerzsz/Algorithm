package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 18:29
 */
public class T687 {

    // 最长同值路径
    // 两个节点之间的路径最长用他们之间的边表示
    // 两种情况
    // 1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
    // 2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val);
        return max;
    }

    private int helper(TreeNode root, int val) {
        if (root == null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        // 这里不+1的原因是因为最长路径是以两个节点之间的边数量为结果的
        max = Math.max(max, left + right);
        // 如果当前的节点值和父节点的节点值相等就返回左结果或者右结果 + 1
        // 因为这里如果和父节点的值相等了 那就说明可以继续向上回溯最大长度 所以选择最长的子树结果向上回溯
        if (root.val == val) return Math.max(left, right) + 1;
        return 0;
    }
}
