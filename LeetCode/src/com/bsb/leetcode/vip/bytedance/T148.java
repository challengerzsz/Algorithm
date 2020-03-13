package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-13 22:39
 */
public class T148 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 归并
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head, q = head, mid = null;
        while (q != null && q.next != null) {
            mid = p;
            p = p.next;
            q = q.next.next;
        }
        // 断链
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(p);
        return merge(left, right);
    }


    // 两条排序链表合并
    private ListNode merge(ListNode left, ListNode right) {
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return fakeHead.next;
    }
}
