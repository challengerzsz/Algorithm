package com.bsb.leetcode.contest.MayFirst;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 10:37
 */
public class T5346 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean res = false;

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root.left == null && root.right == null && head.next == null && head.val == root.val) return true;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        dfs(root, sb.toString());
        return res;
    }

    private void dfs(TreeNode root, String order) {
        if (root == null) return;
        if (res) return;

        res = helper(root, "", order);

        dfs(root.left, order);
        dfs(root.right, order);
    }

    private boolean helper(TreeNode root, String cur, String order) {
        if (root == null) return false;
        cur = cur + root.val;
        if (cur.equals(order) || res) return true;

        return helper(root.left, cur, order) || helper(root.right, cur, order);
    }
}
