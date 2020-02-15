package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-23 18:34
 */
public class T235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootValue = root.val;
        
        int i = p.val;
        
        int j = q.val;

        if (i > rootValue && j > rootValue) {
            // 如果p q 都在root的右子树 向右子树递归
            return lowestCommonAncestor(root.right, p, q);
        } else if (i < rootValue && j < rootValue) {
            // 如果p q 都在root的左子树 向左子树递归
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // 已经找到最近共同祖先
            return root;
        }
    }
}
