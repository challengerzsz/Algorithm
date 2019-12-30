package com.bsb.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-30 17:20
 */
public class T23 {

    // 全部放进优先队列 优先队列利用的是堆排 减少时间复杂度
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        priorityQueue.comparator();
        for (ListNode head : lists) {
            while (head != null) {
                priorityQueue.offer(head);
                head = head.next;
            }
        }
        ListNode newHead = priorityQueue.poll();
        ListNode p = newHead;
        if (newHead != null) {
            p.next = null;
        }
        while (priorityQueue.size() != 0) {
            p.next = priorityQueue.poll();
            p = p.next;
            p.next = null;
        }
        return newHead;
    }
}
