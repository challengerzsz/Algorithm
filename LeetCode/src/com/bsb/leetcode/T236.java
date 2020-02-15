package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 15:18
 */
public class T236 {

    // 所有的递归的返回值有4种可能性，null、p、q、公共祖先
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        // 当找到p或q的时候就会返回
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = LowestCommonAncestor(root.left, p, q);
        TreeNode right = LowestCommonAncestor(root.right, p, q);

        // 对每一层递归调用的root都会对root的左右子树的递归结果做处理
        // 如果左右都存在 就说明pq在以root为父节点的左右子树都出现了 当前的节点就是公共祖先
        if (left != null && right != null) {
            return root;
        } else if (left != null) { // 处理左子树递归结果
            return left;
        } else if (right != null) {// 右子树结果
            return right;
        }
        return null;
    }
}
