package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 15:41
 */
public class T257 {

    public List<String> result = new ArrayList<>();

    // dfs直接递归解 每一层都携带上一层的str进行递归 如果遇到叶子结点 先添加str再添加结果集
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return result;
    }

    private void dfs(TreeNode root, String str) {
        String newStr = str;
        if (root != null) {
            newStr += (str.equals("") ? root.val : "->" + root.val);
            if (null == root.left && null == root.right) result.add(newStr);
            if (null != root.left) dfs(root.left, newStr);
            if (null != root.right) dfs(root.right, newStr);
        }
    }


}
