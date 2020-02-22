package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 21:42
 */
public class T951 {

    // 经过若干次翻转某个节点的左右子树 判断是否能够使root1和root2相同
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val) {
            // 这条件我真的是写了不下7个if归纳的
            // 这里的或条件相当于是进行了交换 只不过用递归的方式替换的交换
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                    (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
        return false;
    }
}
