package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 11:24
 */
public class T494 {

    // 给定一个nums数组和一个目标值S
    // 可以给nums中任何一个数据添加正负符号 使得其求和为S
    // 返回所有可能的结果
    private int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, S, 0);
        return res;
    }

    public void helper(int[] nums, int s, int i) {
        // 必须要到最后一位才是全数组求和
        if (i == nums.length && s == 0) {
            res++;
            return;
        }
        if (i == nums.length) {
            return;
        }
        // 这里就是当前nums[i] 取正或者负的选择
        int s1 = s - nums[i];
        int s2 = s + nums[i];
        helper(nums, s1, i + 1);
        helper(nums, s2, i + 1);
    }

    // subset问题 这里把nums数组分成两部分 一部分为正数集合 另一部分为负数集合 就会得到下面的推导
    // sum(P) - sum(N) = target
    // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    // 2 * sum(P) = target + sum(nums)
    // 即 sum(P) = (target + sum(nums)) / 2
    // 这里需要注意的是(target + sum(nums))必须为偶数这个等式才会成立
    int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int temp : nums) {
            sum += temp;
        }

        // 因为nums是非负整数 如果sum求和都小于S 那么就是无解
        // 如果S + sum不是偶数 同样也是无解 直接不需要通过helper计算结果
        return sum < S || ((S + sum) & 1) == 1 ? 0 : helper(nums, (S + sum) >> 1);
    }

    int helper(int[] nums, int S) {
        // dp[i]代表的含义是从nums中取数相加和为i时有多少种取法
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = S; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[S];
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1};
        new T494().findTargetSumWays2(array, 3);
    }
}
