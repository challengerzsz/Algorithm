package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-30 23:15
 */
public class T86 {

    public ListNode partition(ListNode head, int x) {

        ListNode p = null, q = head, max = null, maxPre = null;
        while (q != null) {
            if (q.val >= x && max == null) {
                max = q;
                maxPre = p;
                continue;
            }
            if (q.val < x && max != null) {
                maxPre.next = q;
                max.next = q.next;
                q = max.next;
                p = max;
            }
            p = q;
            q = q.next;
        }

        return head;
    }
}
