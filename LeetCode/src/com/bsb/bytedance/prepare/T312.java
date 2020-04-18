package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-18 16:59
 */
public class T312 {

    // 戳气球
    // 属实的hard题
    // 但是后来分析了一下发现这个题目确实是贪心题 dp可解 如何定义状态和状态转移是个难题 但是题解写的真的太巧妙了..
    // 真心是一道好题目
    public int maxCoins(int[] nums) {

        // 为了最后的dp转移能够正常 左右添加两个value为1的气球
        int n = nums.length + 2;
        int[] newNums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        newNums[0] = newNums[n - 1] = 1;

        // 自顶向下 递归dp解 记忆化
        int[][] cache = new int[n][n];

        return helper(cache, newNums, 0, n - 1);
    }

    // 转换一下思路
    // 戳爆一个气球就可以将数组分为两部分
    // 那么就寻找每一个区间内能够获得的最大收益 => 对于第一次来说就是整个区间
    // 对于后续的情况肯定是戳爆了若干气球之后对每个区间用相同手段寻找最大
    // 问题就很明确了 子问题就是区间内 戳爆某个气球能带来的最大收益
    // 对每个区间来说都需要找这个需要被戳爆的气球
    // 这样就会造成区间的划分 也就是分治
    public int helper(int[][] cache, int[] nums, int left, int right) {
        // 没法继续分下去
        // 因为至少要保证一个区间内有3个气球才能戳
        if (left + 1 == right) return 0;

        if (cache[left][right] > 0) return cache[left][right];

        int ans = 0;

        // 这里尝试戳爆每个区间的每个气球 计算最大值..
        // 时间复杂度O(n^3)
        // 之所以需要用到记忆化是因为可能存在同样的区间划分
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + helper(cache, nums, left, i) + helper(cache, nums, i, right));

        cache[left][right] = ans;
        return ans;
    }
}
