package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 16:13
 */
public class T538 {

    // BST转换为累加树
    // 累加数的概念是把大于当前节点的值 包括自己 求和作为这个节点的新值
    // 中序遍历获得灵感 中序 左根右 组成升序序列 如果是右根左那么就是降序了
    // 按照这个遍历顺序进行改变当前节点值
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {

            convertBST(root.right);
            // 从左右下脚开始向上回溯 sum就是回溯之前的所有比当前元素都大的求和
            root.val = root.val + sum;
            sum = root.val;

            convertBST(root.left);
            return root;
        }
        return null;
    }

}
