package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 17:02
 */
public class T198 {

    // 打家劫舍 动态规划
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 打家劫舍第一类型
        // 一个数组的连续房子 不能连续抢2家 不然会触发警报..
        // 很简单的动态规划解
        // 对于当前的房子 可以选择抢或者不抢
        // 并且如果要抢的话 必须保证上一个房子不抢
        for (int i = 2; i < nums.length; i++) {
            // 这个房子确定抢或者不抢取max作为这个节点的值
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    // 题解 讲得很清楚 写得也很简单...
    // https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-dong-tai-gui-hua-jie-gou-hua-si-lu-/
    public int rob2(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

}
