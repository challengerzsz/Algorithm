package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-28 13:26
 */
public class T18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        int sum = 0;
        // i < nums.length - 3 是为了保证左基准能满足4数之和
        for (int i = 0; i < nums.length - 3; ++i) {
            // 如果当前元素*4 > target 则说明以当前元素为左基准时 4数之和肯定大雨target 不满足
            if (nums[i] * 4 > target) break;
            // 重复左基准 避免重复答案
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 保证右基准和左基准之间至少2元素
            for (int j = nums.length - 1; j - i > 2; --j) {
                if (nums[j] * 4 < target) break;
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) continue;
                int l = i + 1, r = j - 1;
                while (l < r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < nums.length - 2 && nums[l + 1] == nums[l]) l++;
                        while (r > 2 && nums[r - 1] == nums[r]) r--;
                        l++;
                        r--;
                    } else if (sum > target) {
                        while (r > 2 && nums[r - 1] == nums[r]) r--;
                        r--;
                    } else {
                        while (l < nums.length - 2 && nums[l + 1] == nums[l]) l++;
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
