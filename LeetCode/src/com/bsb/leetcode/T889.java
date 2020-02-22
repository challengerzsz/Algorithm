package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 17:01
 */
public class T889 {

    // 根据前序序列和后序序列构造二叉树
    // 根左右 + 左右根还原二叉树
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    public TreeNode helper(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) return null;
        // 每次都从先序序列中选择第一项作为根节点
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;

        // index下标帮助寻找以当前节点为根节点的时候左右子树的序列在先序序列和后序序列的区间
        // 这里需要注意计算的方式 从先序序列中找到root节点之后就需要找到左右子树的序列范围 然后递归求解
        // 举个例子
        // 先序 => 1|,2,4,5,|3,6,7 |
        // 后序 =>  | 4,5,2,|6,7,3,|1
        // 可以看出来245和425就是以1为root的情况下的左子树
        int index = 0;
        while (post[index] != pre[preStart + 1]) {
            index++;
        }
        root.left = helper(pre, post, preStart + 1, preStart + 1 + index - postStart,
                postStart, index);
        root.right = helper(pre, post, preStart + 2 + index - postStart, preEnd,
                index + 1, preEnd - 1);
        return root;

    }
}
