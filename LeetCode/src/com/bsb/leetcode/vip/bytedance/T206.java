package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 14:54
 */
public class T206 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 翻转链表
    // 遍历原链表 头插
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode p = null;
        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            newNode.next = p;
            p = newNode;
            cur = cur.next;
        }

        return p;
    }

    // 双指针迭代
    public ListNode reverseListBetter(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // 递归
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseListRecursion(head.next);

        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // 而head是4，head的下一个是5，下下一个是空
        // 相当于就是一个断链的过程
        // 1->2->3->4->5->null => 1->2->3->4->null 5->4->null return 5
        // 1->2->3->4->null 5->4->null => 1->2->3->null 5->4->3->null return 5
        // 递归的每一趟都是返回的原始链表的最后一个节点
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
