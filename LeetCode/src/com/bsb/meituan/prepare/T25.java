package com.bsb.meituan.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 16:53
 */
public class T25 {

    // k个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode p = fakeHead, q = fakeHead;

        while (q.next != null) {
            for (int i = 1; i <= k && q != null; i++) q = q.next;
            if (q == null) break;
            ListNode after = q.next;
            q.next = null;
            ListNode start = p.next;
            p.next = helper(start);
            start.next = after;
            p = start;
            q = start;
        }

        return fakeHead.next;
    }

    private ListNode helper(ListNode p) {
        ListNode q = null;
        while (p != null) {
            ListNode after = p.next;
            p.next = q;
            q = p;
            p = after;
        }
        return q;
    }
}
