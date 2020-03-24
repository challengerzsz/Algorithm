package com.bsb.meituan.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 15:18
 */
public class T23 {

    // 合并k个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i];
        int mid = (i + j) / 2;
        ListNode l = merge(lists, i, mid);
        ListNode r = merge(lists, mid + 1, j);

        return sort(l, r);
    }

    private ListNode sort(ListNode p, ListNode q) {
        if (p == null) return q;
        if (q == null) return p;

        if (p.val < q.val) {
            p.next = sort(p.next, q);
            return p;
        } else {
            q.next = sort(p, q.next);
            return q;
        }
    }
}
