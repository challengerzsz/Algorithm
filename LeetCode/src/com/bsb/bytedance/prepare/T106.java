package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-15 21:22
 */
public class T106 {

    // 中后序序列还原二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;

        return helperRebuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helperRebuildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder,
                                       int postorderStart, int postorderEnd) {

        if (postorderStart == postorderEnd) return null;

        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int inorderIndex = 0;
        for (int i = 0; i <= inorderEnd; i++) {
            if (inorder[i] == postorder[postorderEnd]) {
                inorderIndex = i;
                break;
            }
        }

        int rightSubTreeNum = inorderEnd - inorderIndex;
        root.right = helperRebuildTree(inorder, inorderIndex + 1, inorderEnd, postorder,
                postorderEnd - rightSubTreeNum, postorderEnd - 1);
        root.left = helperRebuildTree(inorder, inorderStart, inorderIndex - 1, postorder,
                postorderStart, postorderEnd - rightSubTreeNum - 1);
        return root;
    }
}
