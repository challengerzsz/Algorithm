package com.bsb.leetcode.interview.simulate.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-03 21:15
 */
public class T1 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    // 给定一条升序链表
    // 转换为高度平衡二叉树
    // 中序序列
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
