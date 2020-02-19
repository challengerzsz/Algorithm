package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 20:38
 */
public class T1038 {


    // 改变这棵bst的所有节点的值为大于该节点的和(包括自己)
    // 对于每一个节点来说 比他大的值是自己父节点的右子树的和 父节点能够上推到root
    // 所以直接从BST的最右下角节点开始回溯
    // 这里需要注意要维护一个全局的sum 其实回溯的终点就是在这里
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    // 如果helper方法增加一个sum参数的话 回溯之后sum其实只是每一层方法调用的局部变量
    // 因为对于每个节点来说都需要依赖之前的所有计算结果 所以需要维护全局的sum
    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);

    }
}
