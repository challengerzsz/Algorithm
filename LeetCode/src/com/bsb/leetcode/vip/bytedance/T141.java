package com.bsb.leetcode.vip.bytedance;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-13 22:28
 */
public class T141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 判断链表是否成环
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;

            set.add(head);
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
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
