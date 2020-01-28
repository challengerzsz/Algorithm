package com.bsb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 17:11
 */
class Node2 {
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class T138 {

    // 字节第二次面试一面算法
    public Node2 copyRandomList(Node2 head) {
        if (head == null) return null;
        Map<Node2, Node2> map = new HashMap<>();
        Node2 node = head;
        while (node != null) {
            map.put(node, new Node2(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }


}
