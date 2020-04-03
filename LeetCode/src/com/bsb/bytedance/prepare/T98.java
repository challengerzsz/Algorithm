package com.bsb.bytedance.prepare;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 17:12
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class T98 {

    public boolean isValidBST(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null && pre.val >= p.val) return false;
            pre = p;
            p = p.right;
        }
        return true;

    }

    // 递归 + 约定上下界
    public boolean isValid(TreeNode root, long left, long right) {
        if (root == null) return true;
        else if (root.val <= left || root.val >= right) return false;
        return isValid(root.left, left, root.val) && isValid(root.right, root.val, right);
    }

    public boolean isValidBST2(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
