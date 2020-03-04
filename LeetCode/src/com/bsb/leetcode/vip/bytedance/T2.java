package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 11:31
 */
public class T2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // 7 -> 0 -> 8
    // 考虑进位
    // 最后需要的链表也是逆序的 那直接加就好了
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = fakeHead;
        // 进位
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            // 计算进位
            // 两条链表每个节点只能保存个位数
            // 加法中不可能出现按位加进位为2
//            if (sum >= 10) carry = 1;
            // 如果按照上面的写法会出现进位加了之后下一位carry还为1 没有消除carry
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        // 处理同样长度的两条链表最终需要进位的情况
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return fakeHead.next;
    }
}
