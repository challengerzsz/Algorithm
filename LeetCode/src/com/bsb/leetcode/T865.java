package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 16:17
 */
public class T865 {

    // 具有所有最深节点的最小子树
    // 每个节点的深度是该节点到根节点的最短距离
    // 求具有最深深度的节点 以及它的子树
    // 对每个节点来说 都通过helper计算最大深度
    // 如果某个节点的左右子树的高度一致 则直接返回
    // 如果某个节点的左右子树高度不一致 向较深的子树递归
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int leftDeep = helper(root.left);
        int rightDeep = helper(root.right);
        if (leftDeep == rightDeep)
            return root;
        else if (leftDeep > rightDeep) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }


    int helper(TreeNode root) {
        if (root == null)
            return 0;
        else return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}
