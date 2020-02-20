package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 10:02
 */
public class T655 {

    // 输出二叉树 这个题目的输出结果就是按照树形去填充一个二维数组
    public List<List<String>> printTree(TreeNode root) {
        // 获取二叉树的最大深度
        int deep = getDeep(root);
        // 仔细观察题意之后其实就是一个行为deep 列为2^deep - 1的二维矩阵
        String[][] res = new String[deep][(1 << deep) - 1];
        // 初始化每一行为空串
        for (String[] arr : res) Arrays.fill(arr, "");
        List<List<String>> ans = new ArrayList<>();
        // 填充
        helper(res, root, 0, 0, res[0].length);
        // 每一行作为结果添加到结果集
        for (String[] arr : res) ans.add(Arrays.asList(arr));
        return ans;
    }

    private void helper(String[][] res, TreeNode root, int row, int l, int r) {
        if (root == null) return;
        // 这里其实就是类似二分的思路
        res[row][(l + r) / 2] = "" + root.val;
        helper(res, root.left, row + 1, l, (l + r) / 2);
        helper(res, root.right, row + 1, (l + r + 1) / 2, r);
    }

    private int getDeep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDeep(root.left), getDeep(root.right)) + 1;
    }
}
