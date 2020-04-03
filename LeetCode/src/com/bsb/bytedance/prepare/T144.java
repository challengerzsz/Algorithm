package com.bsb.bytedance.prepare;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 20:32
 */
public class T144 {

    public List<Integer> proOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.offer(p);
                p = p.left;
            }

            TreeNode temp = stack.pollLast();
            p = temp.right;
        }
        return res;
    }
}
