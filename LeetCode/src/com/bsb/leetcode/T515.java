package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 20:08
 */
public class T515 {

    // 找到每一行的最大值
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);
        int queueSize;
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            queueSize = queue.size();
            for (int i = 1; i <= queueSize; i++) {
                TreeNode temp = queue.poll();
                if (temp.val > max) max = temp.val;
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            res.add(max);
        }
        return res;
    }
}
