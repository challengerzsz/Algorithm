package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 19:03
 */
public class T40 {

    public List<List<Integer>> res = new ArrayList<>();

    // 这题和上题不一样的地方在于每一个元素只能出现在每一个结果集中一次
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTraceHelper(candidates, 0, new LinkedList<>(), target);
        return res;
    }
    // 递归至本层需要处理什么是递归的关键
    private void backTraceHelper(int[] candidates, int start, LinkedList<Integer> preList, int target) {
        // 递归出口
        if (target < 0) return;
        // 符合条件时
        if (target == 0) {
            res.add(new ArrayList<>(preList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            preList.addLast(candidates[i]);
            backTraceHelper(candidates, i + 1, preList, target - candidates[i]);
            preList.removeLast();
        }
    }
}
