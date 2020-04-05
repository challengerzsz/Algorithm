package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-05 19:53
 */
public class T148 {

    // 排序链表
    // 归并
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;

        ListNode p = head, q = head, mid = null;
        while (q != null && q.next != null) {
            mid = p;
            p = p.next;
            q = q.next.next;
        }
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(p.next);

        return merge(left, right);
    }


    // 两条排序链表合并
    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
