package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-09 11:10
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class T199 {

    // 这里不要使用全局的list,leetcode的测试用例会循环调这个方法..也就导致全局list没有清空..
    static List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return Collections.emptyList();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list, int max) {
        if (root == null) return;
        if (max == list.size()) list.add(root.val);
        dfs(root.right, list,  max + 1);
        dfs(root.left, list, max + 1);
    }


    public static void main(String[] args) {
        TreeNode root = null;
        List<Integer> ans = new T199().rightSideView(root);
        System.out.println(ans.size());
        for (Integer a : ans) {
            System.out.println(a);
        }
    }
}
