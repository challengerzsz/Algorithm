package com.bsb.meituan.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 11:04
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class T206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(-1);
        ListNode p = head, q;

        while (p != null) {
            q = p.next;
            p.next = fakeHead.next;
            fakeHead.next = p;
            p = q;
        }
        return fakeHead.next;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = reverseList2(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }
}