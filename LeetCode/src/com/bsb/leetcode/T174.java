package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 17:47
 */
public class T174 {

    // 地下城游戏
    // dfs直接搜
    int res = Integer.MAX_VALUE;

    public int calculateMinimumHP(int[][] dungeon) {
        helper(0, 0, 1, 1, dungeon);
        return res;
    }

    /**
     * @param health    当前生命值
     * @param addHealth 已经增加的生命值
     */
    private void helper(int j, int i, int health, int addHealth, int[][] dungeon) {
        // 加上当前位置的奖励或惩罚
        health = health + dungeon[i][j];
        // 此时是否需要加血，加血的话就将 health 加到 1
        if (health <= 0) {
            addHealth = addHealth + Math.abs(health) + 1;
        }

        // 是否到了终点
        if (j == dungeon[0].length - 1 && i == dungeon.length - 1) {
            res = Math.min(addHealth, res);
            return;
        }

        // 是否加过血
        if (health <= 0) {
            // 加过血的话，health 就变为 1
            if (j < dungeon[0].length - 1) {
                helper(j + 1, i, 1, addHealth, dungeon);
            }
            if (i < dungeon.length - 1) {
                helper(j, i + 1, 1, addHealth, dungeon);
            }
        } else {
            // 没加过血的话，health 就是当前的 health
            if (j < dungeon[0].length - 1) {
                helper(j + 1, i, health, addHealth, dungeon);
            }
            if (i < dungeon.length - 1) {
                helper(j, i + 1, health, addHealth, dungeon);
            }
        }

    }


    // 尝试dp解 这题给定的题意很容易想到用动态规划
    // 骑士的行走只能向右或者向下
    // 其实就是找其实刚好救了公主并且救完刚好死 给这个结果+1 就是最终的最小生命值
    // dp[i][j] 其实就是走到dungeon[i][j]的时候的最小生命
    public int calculateMinimumHPByDp(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowLength = dungeon.length;
        int colLength = dungeon[0].length;

        int[][] dp = new int[rowLength][colLength];
        // 设置最后一个值 从公主所在的右下角开始向上填dp
        // 如果公主最后的位置是一个减生命值的格子 那么默认到这里的生命值为0
        dp[rowLength - 1][colLength - 1] = Math.max(0, -dungeon[rowLength - 1][colLength - 1]);

        // 设置最后一列的值
        for (int i = rowLength - 2; i >= 0; --i) {
            int needMin = dp[i + 1][colLength - 1] - dungeon[i][colLength - 1];
            dp[i][colLength - 1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = colLength - 2; i >= 0; --i) {
            int needMin = dp[rowLength - 1][i + 1] - dungeon[rowLength - 1][i];
            dp[rowLength - 1][i] = Math.max(0, needMin);
        }

        for (int i = rowLength - 2; i >= 0; --i) {
            for (int j = colLength - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        // 这里需要+1 因为不能救完就死 还需要跟粑粑公主谈恋爱
        return dp[0][0] + 1;
    }
}
