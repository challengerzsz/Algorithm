package com.bsb.leetcode;

import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 20:14
 */
public class T559 {

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

    // n叉树的最大深度
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int deep = 0;
        for (int i = 0; i < root.children.size(); i++) {
            deep = Math.max(deep, maxDepth(root.children.get(i)));
        }
        return deep + 1;
    }
}
