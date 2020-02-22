package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 20:25
 */
public class T897 {

    // 递增顺序查找树
    // 按中序遍历的顺序重构这个二叉树 使其每个节点只有右子树没有左子树
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return null;

        helper(root, list);
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode p = newRoot;
        for (int i = 1; i < list.size(); i++) {
            p.right = new TreeNode(list.get(i));
            p = p.right;
        }
        return newRoot;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
