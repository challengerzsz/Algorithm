package com.bsb.meituan.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 15:04
 */
public class T141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode p = head, q = head.next;
        while (p != q) {
            if (q == null || q.next == null) return false;
            p = p.next;
            q = q.next.next;
        }
        return true;
    }
}
