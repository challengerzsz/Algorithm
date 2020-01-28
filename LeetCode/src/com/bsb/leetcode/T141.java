package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 19:11
 */
public class T141 {

    // 环形链表
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
