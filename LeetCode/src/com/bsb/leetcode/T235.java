package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-23 18:34
 */
public class T235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
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

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        
        int pVal = p.val;
        
        int qVal = q.val;
        
        TreeNode temp = root;

        // 迭代代替递归
        while (temp != null) {
            
            int parentVal = temp.val;

            if (pVal > parentVal && qVal > parentVal) {
                // 如果p和q都是在root的右子树 
                // 模拟递归过程向右子树递归
                temp = temp.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // 如果p和q都在左子树 向左子树迭代 模拟递归
                temp = temp.left;
            } else {
                // 发现结果
                return temp;
            }
        }
        return null;
    }
}
