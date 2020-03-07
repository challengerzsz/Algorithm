package com.bsb.leetcode.vip.bytedance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 18:21
 */
public class T145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pollLast();
            res.addFirst(temp.val);
            if (temp.left != null) stack.add(temp.left);
            if (temp.right != null) stack.add(temp.right);
        }
        return res;
    }
}
