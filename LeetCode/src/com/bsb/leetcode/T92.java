package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-20 14:44
 */
public class T92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // 区间内反转链表
        // 题目要求一次遍历
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        ListNode nextHead = node.next;
        ListNode next = null;
        ListNode pre = null;
        // 反转m到n这一段
        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        node.next.next = next;
        node.next = pre;
        return res.next;
    }
}
