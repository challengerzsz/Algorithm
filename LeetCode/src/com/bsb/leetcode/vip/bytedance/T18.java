package com.bsb.leetcode.vip.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 10:15
 */
public class T18 {

    // 四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);

        int sum;
        for (int left = 0; left < nums.length - 3; left++) {
            if (nums[left] * 4 > target) break;
            if (left > 0 && nums[left - 1] == nums[left]) continue;
            for (int right = nums.length - 1; right - left > 2; right--) {
                if (nums[right] * 4 < target) break;
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) continue;
                int i = left + 1, j = right - 1;
                while (i < j) {
                    sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[left], nums[right], nums[i], nums[j]));
                        while (i < nums.length - 2 && nums[i + 1] == nums[i]) i++;
                        while (j > 2 && nums[j - 1] == nums[j]) j--;
                        i++;
                        j--;
                    } else if (sum < target) {
                        while (i < nums.length - 2 && nums[i + 1] == nums[i]) i++;
                        i++;
                    } else {
                        while (j > 2 && nums[j - 1] == nums[j]) j--;
                        j--;
                    }
                }
            }
        }
        return res;
    }
}
