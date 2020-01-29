package com.bsb.leetcode;

import java.util.ArrayList;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 16:35
 */
public class T173 {


    // 二叉树迭代器 中序序列
    ArrayList<Integer> list;
    int index;

    public T173(TreeNode root) {

        this.list = new ArrayList<>();

        this.index = -1;

        this.inorder(root);
    }

    // 中序
    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        this.inorder(root.left);
        this.list.add(root.val);
        this.inorder(root.right);
    }

    public int next() {
        return this.list.get(++this.index);
    }

    public boolean hasNext() {
        return this.index + 1 < this.list.size();
    }
}
