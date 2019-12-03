package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-02 22:06
 */
public class T19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        while (n != 0) {
            q = q.next;
            n--;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }
        if (q == head) {
            head.next = null;
        } else {
            p.next = q;
        }
        return head;
    }
}
