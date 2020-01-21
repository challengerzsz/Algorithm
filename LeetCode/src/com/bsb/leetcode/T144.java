package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 10:24
 */
public class T144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // 非递归
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
