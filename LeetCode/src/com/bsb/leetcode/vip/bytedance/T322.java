package com.bsb.leetcode.vip.bytedance;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 20:01
 */
public class T322 {

    // 零钱兑换
    // 最少兑换的硬币数量
    // 46 / 182 未通过
    private int count = 0;
    private int cur;

    public int coinChange(int[] coins, int amount) {
        this.cur = amount;
        Arrays.sort(coins);
        helper(coins, amount);
        if (cur != 0) return -1;
        return count;
    }

    private void helper(int[] coins, int amount) {
        if (amount == 0) return;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (cur == 0) return;
            if (coins[i] > amount) continue;
            if (amount % coins[i] == 0) {
                count += amount / coins[i];
                cur = 0;
                return;
            }
            count += amount / coins[i];
            coinChange(coins, amount - (amount / coins[i]) * coins[i]);
        }
    }

    // dp[i] 表示amount == i的时候需要多少硬币找零
    public int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int temp : coins) {
                // 当前的i不能够用temp找零
                if (temp > i) continue;
                dp[i] = Math.min(dp[i], dp[i - temp] + 1);
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        new T322().coinChange(new int[]{186, 419, 83, 408}, 6249);
    }
}
