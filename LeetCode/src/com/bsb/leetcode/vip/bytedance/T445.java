package com.bsb.leetcode.vip.bytedance;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-24 20:16
 */
public class T445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode lastNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a1 = 0, a2 = 0;
            if (!stack1.isEmpty()) {
                a1 = stack1.removeFirst();
            }
            if (!stack2.isEmpty()) {
                a2 = stack2.removeFirst();
            }
            ListNode curNode = new ListNode((a1 + a2 + carry) % 10);
            carry = (a1 + a2 + carry) / 10;
            curNode.next = lastNode;
            lastNode = curNode;
        }
        if (carry > 0) {
            ListNode curNode = new ListNode(carry);
            curNode.next = lastNode;
            lastNode = curNode;
        }
        return lastNode;
    }
}
