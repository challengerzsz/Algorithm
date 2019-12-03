package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-30 23:01
 */
public class T160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;

        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
