package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-10 16:33
 */
public class T15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int r = 0, l = 0, sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] > nums[i]) continue;
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[r] + nums[l];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                    l++;
                }
                if (sum > 0) {
                    r--;
                    continue;
                }
                if (sum < 0) {
                    l++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 0, 0};
        new T15().threeSum(array);
    }
}
