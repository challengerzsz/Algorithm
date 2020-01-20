package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-20 18:20
 */
public class T113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        sum -= root.val;

        list.add(root.val);
        if (root.left == null && root.right == null && sum == 0)
            res.add(new ArrayList<>(list));

        helper(root.left, sum, list);
        helper(root.right, sum, list);

        // 递归返回的时候如果不应该在结果集 不要忘记remove
        list.remove(list.size() - 1);
    }
}
