package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-30 14:47
 */
public class T21 {
    // 题解好像并没有要求是新链表 这里做麻烦了
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode t = newHead;
        while (p != null && q != null) {
            if (p.val > q.val) {
                t.next = new ListNode(q.val);
                t = t.next;
                t.next = null;
                q = q.next;
            } else {
                t.next = new ListNode(p.val);
                t = t.next;
                t.next = null;
                p = p.next;
            }
        }
        // 可以直接把没有遍历完的链表加在后面
        while (p != null) {
            t.next = new ListNode(p.val);
            t = t.next;
            t.next = null;
            p = p.next;
        }
        while (q != null) {
            t.next = new ListNode(q.val);
            t = t.next;
            t.next = null;
            q = q.next;
        }
        return newHead.next;
    }
}
