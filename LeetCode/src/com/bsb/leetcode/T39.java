package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 15:30
 */
public class T39 {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTraceHelper(candidates, new ArrayList<>(), target, 0, 0);
        return res;
    }
    private void backTraceHelper(int[] candidates, List<Integer> preList, int target, int sum, int start) {
        if (sum == target) {
            // 这里要add新list实例 因为回溯过程中会对preList进行remove元素 不然会出错
            res.add(new ArrayList<>(preList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                preList.add(candidates[i]);
                backTraceHelper(candidates, preList, target, sum + candidates[i], i);
                preList.remove(preList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        new T39().combinationSum(array, 7);
    }
}
