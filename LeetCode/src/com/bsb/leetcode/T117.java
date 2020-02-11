package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 19:40
 */
public class T117 {

    // 填充每个节点的下一个右侧节点指针II
    // 这个解其实相当于BFS 层次遍历
    public Node connect(Node root) {

        // 其实这个题和116差不多一样，上一个题的一开始的思路就是层次遍历去连接next指针
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node p = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                // 这里注意一下连接的先后顺序以及第几个节点需要连接
                // 这里只需要连接不是在每一层最右侧的next指针就好了 因为所有的next指针都被置为null
                if (i > 0) {
                    p.next = cur;
                }
                p = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
        }
        return root;
    }

    public Node connectByFakeHead(Node root) {
        // 直观的把一颗二叉树每一层当作链表来处理
        // tail会在每一棵子树的2层之间变化 tail同时也是能够帮助fakeHead找到下一层的头节点 并且fakeHead能够帮助cur连接下一层的节点
        Node cur = root;
        while (cur != null) {
            // 伪头节点
            Node fakeHead = new Node();
            // 每一层的末尾节点
            Node tail = fakeHead;
            // 遍历 cur 的当前层
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            // 更新 cur 到下一层
            cur = fakeHead.next;
        }
        return root;
    }
}
