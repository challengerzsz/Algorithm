package com.bsb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-29 10:09
 */
public class T968 {

    // 监控二叉树
    // 如果给某个节点安装了监视器
    // 这个监视器可以监视这个节点和他的父节点以及自己的子节点
    // 需要最少的监视器数量
    private int res = 0;

    public int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null) {
            return ++res;
        }
        dfs(root, 0);
        return res;
    }

    // 思路 dfs的时候区分层级 每遇到奇数层res++
    // 解答错误
    private void dfs(TreeNode root, int deep) {
        if (root == null) return;
        if (deep % 2 != 0) res++;
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }

    // 思路2： 通过maxDeep看整个二叉树的最大深度的奇偶性来安排
    // 解答错误
    public int minCameraCover2(TreeNode root) {
        if (root.left == null && root.right == null) {
            return ++res;
        }
        int maxDeep = countMaxDeep(root);
        System.out.println(maxDeep);
        boolean flag = maxDeep % 2 == 0;
        dfs2(root, 0, flag);
        return res;
    }

    private void dfs2(TreeNode root, int deep, boolean flag) {
        if (root == null) return;
        if (flag) {
            if (deep % 2 == 0) res++;
        } else {
            if (deep % 2 != 0) res++;
        }
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }

    private int countMaxDeep(TreeNode root) {
        if (root == null) return 0;

        return Math.max(countMaxDeep(root.left), countMaxDeep(root.right)) + 1;
    }


    // 贪心
    // 被监视器覆盖的节点
    private Set<TreeNode> covered;

    public int minCameraCover3(TreeNode root) {
        res = 0;
        covered = new HashSet<>();
        covered.add(null);

        dfs(root, null);
        return res;
    }

    /**
     * 自底向上
     * 如果某个节点有父节点 那么最好把摄像头放在父节点上
     * 如果某个节点没有父节点 并且自己也没有被摄像头覆盖 那么这个节点必须放置一个摄像头
     * @param node 当前节点
     * @param pre 父节点
     */
    public void dfs(TreeNode node, TreeNode pre) {
        if (node == null) return;

        dfs(node.left, node);
        dfs(node.right, node);

        // 父节点为空 且该节点没有被覆盖
        // 该节点左节点未被覆盖
        // 该节点右节点未被覆盖
        // 都需在该节点安排监视器
        if (pre == null && !covered.contains(node) || !covered.contains(node.left) || !covered.contains(node.right)) {
            res++;
            // 添加该节点 父节点 左右节点进入覆盖集合
            covered.add(node);
            covered.add(pre);
            covered.add(node.left);
            covered.add(node.right);
        }
    }

}
