package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-11 23:06
 */
public class T24 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode pre = fakeHead;

        while ((head != null) && (head.next != null)) {

            ListNode p = head;
            ListNode q = head.next;

            pre.next = q;
            p.next = q.next;
            q.next = p;

            pre = p;
            head = p.next;
        }

        return fakeHead.next;
    }
}
