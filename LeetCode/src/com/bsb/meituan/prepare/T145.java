package com.bsb.meituan.prepare;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-24 09:17
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class T145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;

        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            res.add(0, cur.val);
            if (cur.left != null) stack.offer(cur.left);
            if (cur.right != null) stack.offer(cur.right);
        }

        return res;
    }
}
