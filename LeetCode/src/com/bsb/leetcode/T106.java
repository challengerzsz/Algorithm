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

    // 中序和后序序列重建二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        // 中序节点值和中序节点在中序数组中下标组成k-v
        for (int i = 0; i <= index; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, index);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        // 后序遍历数组的特点就是左右根 对于任何一颗子树来说 根节点都是出现在后序遍历序列后面的位置
        // 先拿到根节点的值 确定其在中序遍历的位置 并且将其后序遍历的索引值的末尾往前一位
        // 拿到当前子树根节点对应在中序序列中的index
        int inOrderRootIndex = map.get(postorder[index]);
        // 构建当前子树的根节点
        // 注意 这里的index-- 在第一层递归的时候这里还是构建的是整棵树的root
        TreeNode root = new TreeNode(postorder[index--]);
        // 必须先递归右子树 再递归左子树 因为后序是左右根的顺序 后序末尾减一对应的节点应该是右子树的根节点
        // 所以必须全部右子树构建完成再去构建左子树
        root.right = helper(inorder, postorder, inOrderRootIndex + 1, inEnd);
        root.left = helper(inorder, postorder, inStart, inOrderRootIndex - 1);
        return root;
    }

}
