package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-10 17:09
 */
public class T16 {

    public int threeSumClosest(int[] nums, int target) {
        int sum = 0, dis = Integer.MAX_VALUE, res = 0;
        int l = 0, r = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < dis) {
                    dis = Math.abs(sum - target);
                    res = sum;
                } else if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-1, 2, 1, -4};
        System.out.println(new T16().threeSumClosest(array, 1));
    }
}
