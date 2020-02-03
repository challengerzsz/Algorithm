package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 14:34
 */
public class T47 {

    // 全排列II 包括重复元素
    // 去重的话不太好在结果集中对List去重
    // 所以在递归的时候需要判断什么程度需要剪枝避免重复递归
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 这里排序的目的是为了方便剪枝
        Arrays.sort(nums);
        // 配合剪枝的占用数组
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> deque, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {

                // 在 used[i - 1] 刚刚被撤销的时候剪枝，说明接下来会被选择，搜索一定会重复，所以剪枝
                // 例如[1, 1, 2, 3]
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                deque.addLast(nums[i]);
                dfs(nums, len, depth + 1, used, deque, res);

                // 回溯
                deque.removeLast();
                used[i] = false;
            }
        }
    }
}
