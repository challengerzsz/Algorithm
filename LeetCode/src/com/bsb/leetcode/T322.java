package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 16:53
 */
public class T322 {

    // 零钱兑换
    // 给定所有的coin面值
    // 计算兑换amount所需的最小coins数量
    // 暴搜 超时
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 当前取coin不合法
            if (amount - coin < 0) continue;
            int subRes = coinChange(coins, amount - coin);
            // 子问题无解
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 记忆化 超时
    public int coinChange2(int[] coins, int amount) {

        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        return helper(coins, amount, cache);
    }

    private int helper(int[] coins, int amount, int[] cache) {
        if (amount == 0) return 0;
        // 记忆化剪枝
        if (cache[amount] != -1) return cache[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;
            int subRes = helper(coins, amount - coin, cache);
            // 无解
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        // 记录本次递归的答案
        cache[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return cache[amount];
    }

    // 动态规划
    // dp[i] 表示i所需要的最小兑换的金币个数
    int coinChangeByDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 这里需要一个较大的数 后序状态转换的时候需要用到选择当前coin之前最少次数和初始化的这个次数做比较
        Arrays.fill(dp, amount + 1);
        // 0的话需要0个硬币兑换
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins)
                // 选择coin的话 最小值其实和 amount - coin的最小是多少有关系
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        new T322().coinChangeByDp(coins, 11);
    }
}
