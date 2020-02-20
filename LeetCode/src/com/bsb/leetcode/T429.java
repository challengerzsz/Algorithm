package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 17:47
 */
public class T429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // N叉树层次遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> everyLevel = new ArrayList<>();
            res.add(everyLevel);
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                res.get(level).add(temp.val);
                for (Node node : temp.children) {
                    if (node != null) queue.offer(node);
                }
            }
            level++;
        }
        return res;
    }
}
