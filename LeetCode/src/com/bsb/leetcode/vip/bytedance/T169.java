package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-13 22:14
 */
public class T169 {

    // 超过n/2的元素
    // 摩尔投票
    public int majorityElement(int[] nums) {
        int cur = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) count++;
            else count--;
            if (count == 0) {
                cur = nums[i];
                count = 1;
            }
        }

        return cur;
    }
}
