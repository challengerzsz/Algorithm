package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 08:46
 */
public class T226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    // 类似BFS 每个节点访问一遍 每访问一次交换该节点的左右子树 并且把该节点的左右节点入队
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
            if (p.left != null) queue.add(p.left);
            if (p.right != null) queue.add(p.right);
        }
        return root;
    }

}
