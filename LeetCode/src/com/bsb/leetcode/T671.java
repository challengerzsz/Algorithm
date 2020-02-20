package com.bsb.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 16:22
 */
public class T671 {

    // 二叉树中第2小的节点
    // HashSet去重 小顶堆降低时间复杂度
    // 时间复杂度O(n) + O(nlogn) + O(logn) = O(nlogn) 12.89%
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        helper(root, set);
        if (set.size() <= 1) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            int temp = iterator.next();
            heap.offer(temp);
        }
        heap.poll();
        return heap.poll();
    }

    private void helper(TreeNode root, Set<Integer> set) {
        if (root == null) return;

        // 这里不需要判断是不是存在 直接塞进去 重复的话底层HashMap会是同一个key
        set.add(root.val);
        helper(root.left, set);
        helper(root.right, set);
    }

    public int findSecondMinimumValue2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        // 左右子节点可能和root节点值一致
        if (left == root.val) {
            left = findSecondMinimumValue2(root.left);
        }
        if (right == root.val) {
            right = findSecondMinimumValue2(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left != -1) {
            return left;
        }
        return right;
    }
}
