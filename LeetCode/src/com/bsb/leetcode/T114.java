package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 16:26
 */
public class T114 {


    public void flatten(TreeNode root) {
        // 将根节点的右子树连接到根节点左子树的最右节点上
        // 交换根节点的左右子树
        // root.left置空
        // 按照上述思路继续处理连接后的子树
        if (root == null) return;
        if (root.left != null) {
            TreeNode pre = root.left;
            while (pre.right != null) pre = pre.right;
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

}
