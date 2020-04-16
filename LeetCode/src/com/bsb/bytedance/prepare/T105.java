package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-15 20:49
 */
public class T105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;

        return helperRebuildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helperRebuildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder,
                                       int inorderStart, int inorderEnd) {

        if (preorderStart == preorderEnd) return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);
        int rootIndexInInorder = 0;
        for (int i = inorderStart; i < inorderEnd; i++) {
            if (inorder[i] == preorder[preorderStart]) {
                rootIndexInInorder = i;
                break;
            }
        }
        int leftSubTreeNum = rootIndexInInorder - inorderStart;
        root.left = helperRebuildTree(preorder, preorderStart + 1,
                preorderStart + leftSubTreeNum + 1, inorder, inorderStart, rootIndexInInorder);
        root.right = helperRebuildTree(preorder, preorderStart + leftSubTreeNum + 1,
                preorderEnd, inorder, rootIndexInInorder + 1, inorderEnd);

        return root;
    }
}
