package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 11:26
 */
public class T501 {

    // 二叉搜索树中的众数
    // 中序+迭代计数
    // 需要注意如果有多个众数
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[1];
        if (root.left == null && root.right == null) return new int[]{root.val};
        helper(root);
        int res = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) == list.get(i)) {
                count++;
                if (count > max) {
                    max = count;
                    res = list.get(i);
                }
                continue;
            }
            count = 0;
        }
        return new int[]{res};
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    private int max = 0;
    private int count = 0;
    List<Integer> res = new LinkedList<>();
    private TreeNode pre = null;

    public int[] findMode2(TreeNode root) {
        inOrderHelper(root);
        int length = res.size();
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = res.get(i);
        }
        return temp;
    }

    private void inOrderHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left);
        if (pre != null && pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        // 这里是多众数和单个众数的选择问题 如果接下来有元素的出现次数 == max 直接添加
        // 如果下一步count > max 证明前面的解都不是众数了
        if (count == max) {
            res.add(root.val);
        } else if (count > max) {
            max = count;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        inOrderHelper(root.right);
    }
}
