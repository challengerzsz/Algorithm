package com.bsb.leetcode.vip.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-31 21:33
 */
public class T39 {

    // 回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int index, ArrayList<Integer> temp) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int start = index; start < candidates.length; start++) {
            temp.add(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
