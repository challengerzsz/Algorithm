package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 20:16
 */
public class T894 {

    // 所有可能的满二叉树(二叉树每个节点要么拥有0个子节点 要么拥有2个子节点)
    // 每个节点值都为0
    // 返回所有可能的二叉树
    // 思路 如果N == 4
    // 可以按照左子树 根节点 右子树划分这个4 为 (1, 1, 2) (2, 1, 1)
    // 按照这种思路进行安排二叉树
    public List<TreeNode> allPossibleFBT(int N) {

        List<TreeNode> res = new ArrayList<>();
        // 偶数不能构成满二叉树
        if (N % 2 == 0) return res;
        if (N == 1) {
            TreeNode head = new TreeNode(0);
            res.add(head);
            return res;
        }

        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode tempLeft : left) {
                for (TreeNode tempRight : right) {
                    TreeNode curRoot = new TreeNode(0);
                    curRoot.left = tempLeft;
                    curRoot.right = tempRight;
                    res.add(curRoot);
                }
            }
        }
        return res;
    }
}
