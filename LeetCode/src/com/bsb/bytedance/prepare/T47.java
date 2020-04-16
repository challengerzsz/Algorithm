package com.bsb.bytedance.prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-15 22:42
 */
public class T47 {

    // 有重复元素的全排列
    // 结果不包含重复解
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, 0, res, used);
        return res;
    }

    private void helper(int[] nums, int index, List<List<Integer>> res, boolean[] used) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int temp : nums) {
                list.add(temp);
            }
            res.add(list);
            return;
        }


        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            swap(nums, i, index);
            used[i] = true;
            helper(nums, index + 1, res, used);
            used[i] = false;
            swap(nums, i, index);
        }
    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
