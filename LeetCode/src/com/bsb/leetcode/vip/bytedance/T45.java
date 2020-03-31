package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-31 20:32
 */
public class T45 {

    // 跳跃游戏II
    // 跳最少次数
    public int jump(int[] nums) {
        int end = 0;
        int max = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找能跳的最远的
            max = Math.max(max, nums[i] + i);
            // 更新end
            if (i == end) {
                end = max;
                steps++;

//                if (end >= nums.length - 1) return steps;
            }
        }
        return steps;
    }
}
