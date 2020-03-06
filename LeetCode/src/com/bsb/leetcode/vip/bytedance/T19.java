package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-06 18:57
 */
public class T19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // 删除链表倒数第k个元素
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode first = head;
        for (int i = 1; i <= n - 1; i++) first = first.next;
        ListNode second =  head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        while (first.next != null) {
            pre = pre.next;
            second = second.next;
            first = first.next;
        }

        pre.next = second.next;
        return fakeHead.next;
    }
}
