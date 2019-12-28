package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-02 22:06
 */
public class T19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        // 1 - 2 - 3 - 4 - 5 - 6 - 7 - null
        for (int i = 0; i < n + 1; i++) {
            if (q != null) q = q.next;
            else return head.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}
