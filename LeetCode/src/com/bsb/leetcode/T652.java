package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 22:06
 */
public class T652 {

    // 找重复的子树
    // 这题一上来的思路就是暴力解
    // 先序遍历之后找重复字符串
    // 结果题目需要返回的是TreeNode的list
    private StringBuilder sb = new StringBuilder();

    public List<TreeNode> helper2(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        helper(root);
        String str = sb.toString();
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.indexOf(str.substring(i, j + 1), i + 1) != -1) {
//                    res.add(str.substring(i, j + 1));
                }
            }
        }
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        sb.append(root.val);
        helper(root.left);
        helper(root.right);
    }

    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper2(root, res, map);
        return res;
    }

    private StringBuilder helper2(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) {
            return new StringBuilder("$");
        }
        StringBuilder left = helper2(root.left, res, map);
        StringBuilder right = helper2(root.right, res, map);
        // 注意这里的加和顺序
        // 添加每个节点的左右子树作为一个串 如果在map中发现重复 就添加结果集
        StringBuilder key = new StringBuilder(root.val + "").append(left).append(right);
        map.put(key.toString(), map.getOrDefault(key.toString(), 0) + 1);
        if (map.get(key.toString()) == 2) {
            res.add(root);
        }
        return key;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        System.out.println(str.substring(0, 1));
        System.out.println(str.indexOf("abc", 3));
    }
}
