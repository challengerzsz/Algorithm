package com.bsb.leetcode.vip.bytedance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-11 22:17
 */
public class T143 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 重排链表
    public void reorderList(ListNode head) {
        if (head == null) return;

        Deque<ListNode> queue = new LinkedList<>();
        ListNode q = head;
        while (q != null) {
            queue.offer(q);
            q = q.next;
        }

        while (!queue.isEmpty()) {
            if (q == null) {
                q = queue.pollFirst();
            } else {
                q.next = queue.pollFirst();
                q = q.next;
            }

            q.next = queue.pollLast();
            q = q.next;
        }
        // 奇数和偶数链表结尾p不一样
        if (q != null) q.next = null;
    }

    // 找middle 断链 翻转后半部分 合并
    public void reorderList2(ListNode head) {
        if (head == null) return;
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        ListNode afterStart = p.next;
        p.next = null;
        ListNode fakeHead = new ListNode(-1);
        while (afterStart != null) {
            ListNode next = afterStart.next;
            afterStart.next = fakeHead.next;
            fakeHead.next = afterStart;
            afterStart = next;
        }
        p = head;
        q = fakeHead.next;
        while (p != null && q != null) {
            ListNode temp = p.next;
            p.next = q;
            q = q.next;
            p.next.next = temp;
            p = p.next.next;
        }

//        System.out.println("debug");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        new T143().reorderList2(head);
    }
}
