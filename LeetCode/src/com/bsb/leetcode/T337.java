package com.bsb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-11 19:55
 */
public class T337 {

    // 打家劫舍III
    // 形如一颗二叉树的房屋
    // 但是不能连续投相连的两家 否则会报警
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 利用cache消除重叠子问题 记忆化 相当于剪枝了
        if (cache.containsKey(root)) return cache.get(root);
        // 抢这一家 然后去下下家
        int robIt = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢 然后去下家
        int notRobIt = rob(root.left) + rob(root.right);

        int res = Math.max(robIt, notRobIt);
        cache.put(root, res);
        return res;
    }

    public int rob2(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    //res[0]为不偷root的最大值 res[1]为偷root的最大值
    private int[] helper(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        // 下面的两次递归函数的调用就是为了化大问题变为小问题了
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        // 不偷root，最大值为两个子树的最大值之和
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷root，最大值为两个子树不偷root的最大值加上根节点的值
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
