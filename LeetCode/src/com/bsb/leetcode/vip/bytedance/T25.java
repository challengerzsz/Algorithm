package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 11:06
 */
public class T25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // k个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode pre = fakeHead;
        ListNode end = fakeHead;

        while (end.next != null) {
            // 找需要翻转的链表区间
            // end向后移动k次
            for (int i = 0; i < k && end != null; i++) end = end.next;
            // 不足k次 不翻转
            if (end == null) break;

            // 记录应该翻转的区间 [start, end] = k
            ListNode start = pre.next;
            // end的后一位 连接链表
            ListNode next = end.next;

            // 为了能够翻转[start, end] end之后先置空
            end.next = null;
            // 翻转链表
            pre.next = helper(start);
            // start此时已经是翻转后最后一个节点
            // 连接翻转区间之后的链表准备下一次翻转
            start.next = next;
            pre = start;

            end = pre;
        }
        return fakeHead.next;
    }

    private ListNode helper(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
}
