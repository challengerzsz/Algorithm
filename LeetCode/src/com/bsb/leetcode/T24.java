package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-28 22:05
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class T24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 构造虚拟头节点
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while (head != null && head.next != null) {
            node.next = head.next;
            head.next = head.next.next;
            node.next.next = head;

            node = node.next.next;
            head = head.next;

        }
        return res.next;
    }

    // 讨论区大佬 及其优雅的递归写法
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
