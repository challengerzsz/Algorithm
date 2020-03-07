package com.bsb.leetcode.vip.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 16:27
 */
public class T199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 二叉树右视图
    private int max = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        helper(root, res, 1);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (level > max) res.add(root.val);
        max = Math.max(max, level);

        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }
}
