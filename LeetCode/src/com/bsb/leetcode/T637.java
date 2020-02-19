package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 21:00
 */
public class T637 {

    // 二叉树每层的平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int len;
        double everyLevelCount = 0;
        while (!queue.isEmpty()) {
            len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                everyLevelCount += temp.val;
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            res.add(1.0 * everyLevelCount / len);
            everyLevelCount = 0;
        }
        return res;
    }
}
