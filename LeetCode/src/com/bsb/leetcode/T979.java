package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-28 21:39
 */
public class T979 {

    // 在二叉树中分硬币
    // 每个节点的值表示这个节点的硬币个数
    // 每次只能在相邻两个节点之间移动1枚硬币
    // 当二叉树的所有节点都有1枚硬币的时候移动次数是多少
    private int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * 后序遍历思路 自底向上回溯的时候累计操作数
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            root.val += dfs(root.left);
        }
        if (root.right != null) {
            root.val += dfs(root.right);
        }
        // 这里的意思是如果后序遍历的第一个应该向上回溯的节点所保存的硬币数量大于1 那么自己只留1枚硬币 其余硬币全部回溯给父节点
        // 如果当前这个节点有一枚硬币 那么res加的其实是0 也就是不需要从父节点获得 也不能给父节点
        // 如果这个节点没有硬币的话 那就需要从父节点获取 res 也需要加1
        res += Math.abs(root.val - 1);
        // 这里直接返回当前硬币个数-1 这个时候递归返回之后会和当前这一步一样地在父节点处理
        // 这也是递归解的意义 不论递归到哪里 每一层都是相同的小问题 通过递归最终得到解决
        return root.val - 1;
    }
}
