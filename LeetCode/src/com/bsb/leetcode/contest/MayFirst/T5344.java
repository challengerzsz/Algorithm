package com.bsb.leetcode.contest.MayFirst;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 10:30
 */
public class T5344 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) return new int[] {};
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[j] < nums[i]) count++;
            }
            res[i] = count;
        }

        return res;
    }
}
