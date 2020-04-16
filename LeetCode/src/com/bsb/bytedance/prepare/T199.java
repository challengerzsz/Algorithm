package com.bsb.bytedance.prepare;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-16 14:27
 */
public class T199 {

    private int max = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        helper(root, res, 1);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int deep) {
        if (root == null) return;

        if (deep > max) {
            res.add(root.val);
            max = deep;
        }

        helper(root.right, res, deep + 1);
        helper(root.left, res, deep + 1);
    }
}
