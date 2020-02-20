package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 11:46
 */
public class T654 {

    // 最大二叉树
    // 二叉树的根是数组中的最大元素
    // 左子树是通过数组中最大值左边部分构造出的最大二叉树
    // 右子树是通过数组中最大值右边部分构造出的最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildHelper(0, nums.length, nums);
    }

    // 分治
    private TreeNode buildHelper(int start, int end, int[] nums) {
        // 边界判断
        if (start >= end) return null;
        int max = nums[start];
        int index = start;
        // 找每个区间的最大节点作为root
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = buildHelper(start, index, nums);
        root.right = buildHelper(index + 1, end, nums);
        return root;
    }

}
