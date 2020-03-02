package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-30 21:34
 */
public class T206 {

    public ListNode reverseList(ListNode head) {
        ListNode p = head, q = head.next;
        head = null;
        while (p != null) {
            p.next = head;
            head = p;
            p = q;
            if (q != null) q = q.next;
        }
        return head;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = null;

        ListNode newHead = new T206().reverseList2(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
