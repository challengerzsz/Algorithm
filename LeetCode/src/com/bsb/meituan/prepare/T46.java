package com.bsb.meituan.prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 17:13
 */
public class T46 {

    // 全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int temp : nums) list.add(temp);
            res.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, index + 1, res);
            swap(nums, i, index);
        }

    }

    private void swap(int[] nums, int i, int index) {
        if (i == index) return;
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
