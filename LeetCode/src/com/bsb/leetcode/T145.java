package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 10:50
 */
public class T145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        // LinkedList还是蛮好用的
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            // 这里是向结果集的最前方插入 因为是后序遍历
            res.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }
}
