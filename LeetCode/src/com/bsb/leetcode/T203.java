package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 18:44
 */
public class T203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;
        ListNode p = fakeHead, q = fakeHead.next;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
                q = q.next;
                continue;
            }
            q = q.next;
            p = p.next;
        }
        return fakeHead.next;
    }
}
