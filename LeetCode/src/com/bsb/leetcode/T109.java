package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 15:02
 */
public class T109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null || head.next == null) {
            return head == null ? null : new TreeNode(head.val);
        }
        ListNode pre = head, mid = head, q = head;
        while (q != null && q.next != null) {
            // 快慢指针法找到中间节点
            pre = mid;
            mid = mid.next;
            q = q.next.next;
        }
        pre.next = null; // 断链(前 mid 后 3部分链表)
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}
