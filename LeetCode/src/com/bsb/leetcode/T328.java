package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-31 11:01
 */
public class T328 {

    // 奇偶链表 分为奇链表和偶链表 相连
    public ListNode danEvenList(ListNode head) {
        if (head == null) return null;
        ListNode dan = head, shuang = head.next, shuangHead = shuang;
        while (shuang != null && shuang.next != null) {
            dan.next = shuang.next;
            dan = dan.next;
            shuang.next = dan.next;
            shuang = shuang.next;
        }
        dan.next = shuangHead;
        return head;
    }
}
