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
            return lowestCommonAncestor(root.right, p, q);
        } else if (i < rootValue && j < rootValue) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
