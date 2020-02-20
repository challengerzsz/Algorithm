package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 11:29
 */
public class T653 {

    // 如果BST中有两个数字之和==k就返回true
    public boolean findTarget(TreeNode root, int k) {
        // 中序序列 找两数字之和==k
        List<Integer> inorderList = new ArrayList<>();
        helper(root, inorderList);
        int i = 0, j = inorderList.size() - 1;
        int sum;
        while (i < j) {
            sum = inorderList.get(i) + inorderList.get(j);
            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
        }
        return false;
    }

    private void helper(TreeNode root, List<Integer> inorderList) {
        if (root == null) return;
        helper(root.left, inorderList);
        inorderList.add(root.val);
        helper(root.right, inorderList);
    }
}
