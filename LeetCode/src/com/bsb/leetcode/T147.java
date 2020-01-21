package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 11:04
 */
public class T147 {


    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        // 伪头节点
        ListNode preHead = new ListNode(0);
        ListNode cur = head;
        ListNode pre = preHead;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;

            pre = preHead;
            cur = next;
        }
        return preHead.next;
    }
}
