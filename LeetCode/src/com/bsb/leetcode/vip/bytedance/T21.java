package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 20:22
 */
public class T21 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        ListNode p = l1, q = l2;
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = p;
                cur = cur.next;
                p = p.next;
            } else if (q.val < p.val) {
                cur.next = q;
                cur = cur.next;
                q = q.next;
            }
        }

        while (p != null) {
            cur.next = p;
            cur = cur.next;
            p = p.next;
        }
        while (q != null) {
            cur.next = q;
            cur = cur.next;
            q = q.next;
        }

        cur.next = null;
        return fakeHead.next;
    }

    // 递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }

}
