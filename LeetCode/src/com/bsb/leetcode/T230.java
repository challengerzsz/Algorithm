package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 10:34
 */
public class T230 {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res.get(k - 1);
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}
