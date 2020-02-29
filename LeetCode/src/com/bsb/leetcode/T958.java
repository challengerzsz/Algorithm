package com.bsb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-29 09:57
 */
public class T958 {

    // 二叉树完全性校验
    // 判断一棵树是不是完全二叉树
    // 每一层节点从左边开始连续
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        queue.offer(root);
        // 装每一层的节点
        while ((cur = queue.removeFirst()) != null) {
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        // 上面一旦发现queue中有null元素 就停止向queue里放元素
        // 如果最后检查的时候从queue的后面取数据发现后面有不为null的元素 那么就证明这不是一棵完全二叉树
        while (!queue.isEmpty()) {
            if (queue.removeLast() != null) {
                return false;
            }
        }
        return true;
    }
}
