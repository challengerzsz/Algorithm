package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 11:40
 */
public class T124 {

    int res = Integer.MIN_VALUE;

    // 困难题目
    // 二叉树中最大路径和 可不经过root
    // 对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
    // 1、其左右子树中所构成的和路径值较大的那个子树方向加上该节点的值后向父节点回溯构成最大路径
    // 2、左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = helper(root.left);
        int right = helper(root.right);
        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        res = Math.max(left + right + root.val, res);
        // 这里的比大小中的0的意思是 如果当前root的左右子树都是负数的话 那么就只能取0或者取root本身 还是取决于root是否是负数
        return Math.max(0, Math.max(left, right) + root.val);
    }
}
