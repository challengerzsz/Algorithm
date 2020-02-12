package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-12 19:55
 */
public class T491 {

    // 寻找所有的递增序列
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        // 结果集可能会重复
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, nums, 0);
        return new ArrayList<>(res);
    }

    // 基本dfs + 回溯
    private void dfs(Set<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        List<Integer> temp = new ArrayList<>(list);
        // 因为需要找子序列
        // 所以只有至少2个的选择才能被添加进结果集
        if (temp.size() >= 2) res.add(temp);
        for (int i = start; i < nums.length; i++) {
            // 如果加入nums[i] 会导致list无序 所以抛弃nums[i]
            if (!list.isEmpty() && list.get(list.size() - 1) > nums[i]) continue;
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
