package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-30 21:58
 */
public class T26 {


    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

}
