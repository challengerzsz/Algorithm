package com.bsb.bytedance.prepare;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 21:13
 */
public class T145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pollLast();
            res.add(0, temp.val);
            if (temp.left != null) stack.offer(temp.left);
            if (temp.right != null) stack.offer(temp.right);
        }
        return res;
    }
}
