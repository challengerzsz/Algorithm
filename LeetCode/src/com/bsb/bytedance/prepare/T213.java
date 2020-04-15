package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-15 15:43
 */
public class T213 {

    // 打家劫舍II
    // 环形数组
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int start, int end) {
        int pre = 0, cur = 0, tmp;
        for (int i = start; i <= end; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }
}
