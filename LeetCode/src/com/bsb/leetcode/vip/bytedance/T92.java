package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-11 23:18
 */
public class T92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode p = fakeHead;
        ListNode q = fakeHead.next;

        int step = 0;
        // 找到需要翻转的前一个节点和需要翻转的头一个节点p q
        while (step < m - 1) {
            p = p.next;
            q = q.next;
            step++;
        }

        // 翻转从q开始的n - m个节点
        for (int i = 0; i < n - m; i++) {
            ListNode temp = q.next;
            q.next = q.next.next;

            temp.next = p.next;
            p.next = temp;
        }

        return fakeHead.next;
    }
}
