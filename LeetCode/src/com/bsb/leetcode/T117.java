package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 19:40
 */
public class T117 {

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
}
