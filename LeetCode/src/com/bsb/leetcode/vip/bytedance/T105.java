package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-24 22:28
 */
public class T105 {

    // 前序中序还原二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;

        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {

        if (pL == pR) return null;

        int rootVal = preorder[pL];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = iL; i < iR; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        int leftNum = rootIndex - iL;
        root.left = helper(preorder, pL + 1, pL + leftNum + 1, inorder,
                iL, rootIndex);
        root.right = helper(preorder, pL + leftNum + 1, pR, inorder, rootIndex + 1, iR);

        return root;
    }
}
