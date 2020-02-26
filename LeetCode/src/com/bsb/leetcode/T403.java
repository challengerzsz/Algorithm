package com.bsb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-26 21:43
 */
public class T403 {

    // 青蛙过河
    // 这个题目的意思是stones数组表示每块石头所在的位置
    // 过河成功的概念是能否跳跃到最后一块石头上
    // 如果每次跳跃为k长度 下一次跳跃可为k - 1、 k、 k + 1且方向朝河对面方向
    public boolean canCross(int[] stones) {
        return helper(stones, 0, 0);
    }

    // 超时
    private boolean helper(int[] stones, int index, int jumpStep) {
        for (int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            // 每一步都会去尝试k - 1、 k、 k + 1这三种长度的跳跃
            if (gap >= jumpStep - 1 && gap <= jumpStep + 1) {
                // 剪枝 证明这种情况能够到达对岸
                if (helper(stones, i, gap)) {
                    return true;
                }
            }
        }
        // 如果能够到达对岸
        return index == stones.length - 1;
    }

    // 记忆化递归
    public boolean canCross2(int[] stones) {
        int[][] memory = new int[stones.length][stones.length];
        for (int[] row : memory) {
            Arrays.fill(row, -1);
        }
        return helper(stones, 0, 0, memory) == 1;
    }

    // 这里明显可以注意到可能在某一步的回溯之后会重复计算上一步回溯之前更深层递归计算出的结果
    // 可以用index 和 jumpStep作为表示递归结果的key递归过程中用上记忆化
    private int helper(int[] stones, int index, int jumpStep, int[][] memory) {
        if (memory[index][jumpStep] != -1) return memory[index][jumpStep];
        for (int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            // 每一步都会去尝试k - 1、 k、 k + 1这三种长度的跳跃
            if (gap >= jumpStep - 1 && gap <= jumpStep + 1) {
                // 剪枝 证明这种情况能够到达对岸
                if (helper(stones, i, gap, memory) == 1) {
                    memory[index][jumpStep] = 1;
                    return 1;
                }
            }
        }
        memory[index][jumpStep] = (index == stones.length - 1) ? 1 : 0;
        // 如果能够到达对岸
        return memory[index][jumpStep];
    }

    // 动态规划
    // 借助HashMap实现填表计算
    // 思路：对每一个位置的石头 将石头位置作为key 所有可能能跳到该石头的step作为value
    public boolean canCrossByDp(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            // 对每一个石头都可能的step进行判断
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    // 在上一步跳k大小的情况下 这一步能否到达之后的某个石头
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        // 如果map中最后一个石头的set集合不为0 则证明最后一块石头能够被跳到
        // 即可以到达终点
        return map.get(stones[stones.length - 1]).size() > 0;
    }

}
