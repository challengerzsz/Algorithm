package com.bsb.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-31 09:36
 */
public class T25 {

    // 借助栈的入出序列完成反转
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                // 取最后一个
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return fakeHead.next;
    }
}
