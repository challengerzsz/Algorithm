package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 19:36
 */
public class T160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = 0, lenB = 0;
        ListNode p = headA, q = headB;
        while (p != null) {
            lenA++;
            p = p.next;
        }
        while (q != null) {
            lenB++;
            q = q.next;
        }

        int dis = Math.abs(lenA - lenB);
        p = headA;
        q = headB;
        if (lenA > lenB) {
            while (dis != 0) {
                p = p.next;
                dis--;
            }
        } else {
            while (dis != 0) {
                q = q.next;
                dis--;
            }
        }

        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }
}
