package com.bsb.bytedance.prepare;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 20:37
 */
public class T94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode p = root;
        while (p!= null || !stack.isEmpty()) {
            while (p != null) {
                stack.offer(p);
                p = p.left;
            }

            TreeNode temp = stack.pollLast();
            res.add(temp.val);
            p = temp.right;
        }
        return res;
    }
}
