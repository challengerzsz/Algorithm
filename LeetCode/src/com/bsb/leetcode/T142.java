package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 19:25
 */
public class T142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 判断是否有环
        while (slow != fast) {
            // 这里加了如果链表无环就退出
            // 但是题目还是不能过 很奇怪
            if (fast.next == null || fast.next.next == null) return head;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        // 重制slow节点 和 fast每次一动找环入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
