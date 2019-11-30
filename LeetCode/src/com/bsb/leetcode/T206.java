package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-30 21:34
 */
public class T206 {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode p = head, q = head.next;
        head = null;
        while (p != null) {
            p.next = head;
            head = p;
            p = q;
            q = q.next;
        }
        return head;
    }
}
