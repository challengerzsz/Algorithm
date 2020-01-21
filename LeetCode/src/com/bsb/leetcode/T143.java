package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 09:48
 */
public class T143 {

    public void reorderList(ListNode head) {
        // 超出内存限制
//        if (head == null) return;
//        ArrayList<ListNode> list = new ArrayList<>();
//        ListNode p = head;
//        while (p != null) {
//            list.add(p);
//            p = p.next;
//        }
//        int i = 0, j = list.size() - 1;
//        boolean flag = false;
//        while (i < j) {
//            if (i == j - 1) {
//                list.get(j).next = null;
//                flag = true;
//            }
//            list.get(i).next = list.get(j);
//            list.get(j).next = list.get(i + 1);
//            i++;
//            j--;
//        }
//        if (!flag) list.get(j).next = null;

        // 利用双端队列
        Deque<ListNode> deque = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            deque.offer(p);
            p = p.next;
        }
        while (!deque.isEmpty()) {
            // 类似合并两链表的过程
            if (p == null) {
                p = deque.pollFirst();
            } else {
                p.next = deque.pollFirst();
                p = p.next;
            }
            p.next = deque.pollLast();
            p = p.next;
        }
        if (p != null) {
            p.next = null;
        }
    }

    // 递归解没理解.. 代码粘过来之后看看

    public void reorderList2(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
    }
}
