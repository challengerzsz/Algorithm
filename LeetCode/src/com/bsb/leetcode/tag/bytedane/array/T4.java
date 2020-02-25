package com.bsb.leetcode.tag.bytedane.array;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 20:50
 */
public class T4 {

    // 最长连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) count++;
            else count = 1;
            if (count > res) res = count;
        }
        return res;
    }
}
