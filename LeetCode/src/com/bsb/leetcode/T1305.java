package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-12 10:16
 */
public class T1305 {


    // 两颗二叉搜索树的所有元素
    // 我的思路 中序+归并
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        if (root1 == null && root2 == null) return res;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);

        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.get(0) < list2.get(0)) {
                res.add(list1.get((0)));
                list1.remove(0);
            } else if (list1.get(0) > list2.get(0)) {
                res.add(list2.get(0));
                list2.remove(0);
            } else {
                res.add(list1.get(0));
                res.add(list2.get(0));
                list1.remove(0);
                list2.remove(0);
            }
        }

        if (!list1.isEmpty()) {
            res.addAll(list1);
        }
        if (!list2.isEmpty()) {
            res.addAll(list2);
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
