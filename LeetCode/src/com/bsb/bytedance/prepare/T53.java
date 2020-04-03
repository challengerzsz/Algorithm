package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 10:58
 */
public class T53 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int now = nums[0];
        for (int i = 1; i < nums.length; i++) {
            now = Math.max(nums[i], now + nums[i]);
            max = Math.max(now, max);
        }
        return max;
    }
}
