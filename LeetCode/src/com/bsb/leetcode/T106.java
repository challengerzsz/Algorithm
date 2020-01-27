package com.bsb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 13:52
 */
public class T106 {

    int index;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        for (int i = 0; i <= index; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, index);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        //先拿到根节点的值,确定其在中序遍历的位置，并且将其后序遍历的索引值的末尾往前一位
        int inorder_root = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index--]);
        // 必须先递归右子树，再递归左子树，因为后序是左右根的顺序，后序末尾自减一，此时应该是右子树的根节点
        // 所以必须全部右子树构建完成再去构建左子树
        root.right = helper(inorder, postorder, inorder_root + 1, inEnd);
        root.left = helper(inorder, postorder, inStart, inorder_root - 1);
        return root;
    }

}
