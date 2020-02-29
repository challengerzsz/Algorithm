package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-29 11:01
 */
public class T971 {

    // 翻转二叉树以匹配先序序列
    // 翻转最小次数
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();

        dfs(root, res, voyage);

        // 如果不能满足题意 返回-1
        if (!res.isEmpty() && res.get(0) == -1) {
            res.clear();
            res.add(-1);
        }

        return res;
    }

    public void dfs(TreeNode node, List<Integer> res, int[] voyage) {
        // 先按照先序遍历的顺序匹配voyage数组
        if (node != null) {
            if (node.val != voyage[index++]) {
                res.clear();
                res.add(-1);
                return;
            }

            if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
                res.add(node.val);
                dfs(node.right, res, voyage);
                dfs(node.left, res, voyage);
            } else {
                dfs(node.left, res, voyage);
                dfs(node.right, res, voyage);
            }
        }
    }

}
