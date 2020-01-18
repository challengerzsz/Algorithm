package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-18 10:04
 */
public class T61 {
    // 题目名称叫旋转链表 要求是链表每个节点都向右移动k次
    // 一开始的思路错了 比如链表长度小于k的时候 我的做法就不能通过用例
    // 第二种思路 把链表首尾相接 两个指针 end和head 表示原单链表的末尾和头节点
    // 移动head和end k次 end.next = null即可
    public ListNode rotateRight(ListNode head, int k) {
//        ListNode p = head, q = head, end;
//        while (p.next != null) {
//            if (k == 0) q = p;
//            k--;
//            p = p.next;
//        }
//        end = p;
//        end.next = head;
//        head = q.next;
//        q.next = null;
//        return head;

        if (head == null) return null;
        if (head.next != null) return head;

        ListNode end = head;
        while (end.next != null) end = end.next;
        end.next = head;
        while (k > 0) {
            head = head.next;
            end = end.next;
            k--;
        }
        end.next = null;
        return head;
    }
}
