package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 16:24
 */
public class T83 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

}
