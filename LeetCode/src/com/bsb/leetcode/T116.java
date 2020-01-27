package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 19:02
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class T116 {

    public Node connect(Node root) {
        if (root == null) return root;

        Node left = root.left;
        Node right = root.right;
        // 划分小问题处理
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        // 对每一个节点都做同样处理 进行连接
        connect(root.left);
        connect(root.right);
        return root;
    }
}
