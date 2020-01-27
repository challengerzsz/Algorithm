package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 11:02
 */
public class T103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        if ((level % 2) == 0) {
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }

        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
