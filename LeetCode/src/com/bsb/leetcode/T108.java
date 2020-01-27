package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 14:41
 */
public class T108 {


    // BST的中序遍历其实就是有序数组
    // 其实也就是一个中序遍历的还原过程
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, l, mid - 1);
        root.right = buildTree(nums, mid + 1, r);
        return root;
    }

}
