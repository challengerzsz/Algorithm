package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 10:40
 */
public class T25 {

    // k个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode pre = fakeHead, end = fakeHead;
        while (end.next != null) {

            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;

            ListNode start = pre.next;
            ListNode nextPart = end.next;

            end.next = null;
            pre.next = helper(start);

            start.next = nextPart;
            pre = start;
            end = pre;
        }
        return fakeHead.next;
    }

    private ListNode helper(ListNode start) {
        if (start.next == null) return start;

        ListNode cur = helper(start.next);

        start.next.next = start;
        start.next = null;
        return cur;
    }
}
