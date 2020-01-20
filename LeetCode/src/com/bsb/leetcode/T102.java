package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-20 17:18
 */
public class T102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }


    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {

        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
    private void helper(TreeNode node, int level) {
        if (levels.size() == level) levels.add(new ArrayList<>());
        // 非递归的思路就是递归的时候加上层数 然后直接add到结果集的对应下标处
        levels.get(level).add(node.val);
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public static void main(String[] args) {

    }

}
