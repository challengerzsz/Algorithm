package com.bsb.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 12:18
 */
public class T662 {
    // 二叉树的最大宽度
    // 统计到每一行不为null的元素之前
    private int max = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return max;
    }

    // dfs的思路就是寻找每一层最大的index与map中最先出现的index做差
    private void dfs(TreeNode root, int level, int index) {
        if (root == null) return;
        if (!map.containsKey(level))
            map.put(level, index);
        max = Math.max(max, index - map.get(level) + 1);
        // index的计算是二叉树的左右子树的方法2
        dfs(root.left, level + 1, index * 2);
        dfs(root.right, level + 1, index * 2 + 1);
    }
}
