package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 11:15
 */
public class T148 {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // 归并排序
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        // 快慢指针找出中位点
        ListNode s = head, f = head.next.next, l, r;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        r = mergeSort(s.next);
        // 给最后的节点末尾置为null
        s.next = null;
        l = mergeSort(head);
        return mergeList(l, r);
    }

    // 合并链表
    private ListNode mergeList(ListNode l, ListNode r) {
        // 伪头节点
        ListNode tmpHead = new ListNode(-1);
        ListNode p = tmpHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return tmpHead.next;
    }
}
