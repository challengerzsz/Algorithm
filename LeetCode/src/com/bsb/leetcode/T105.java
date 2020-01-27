package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 12:13
 */
public class T105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart == preEnd) {
            return null;
        }
        int root_val = preorder[preStart];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int rootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (root_val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        int leftNum = rootIndex - inStart;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftNum + 1,
                inorder, inStart, rootIndex);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, preStart + leftNum + 1, preEnd, inorder,
                rootIndex + 1, inEnd);
        return root;
    }
}
