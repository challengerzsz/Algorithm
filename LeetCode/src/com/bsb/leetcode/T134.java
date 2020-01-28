package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 15:34
 */
public class T134 {

    // 这个题目一开始总是想着去动态规划解 但是又想不出来dp数组能够表示什么意思
    // 题解的O(n)解法实在是妙
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTank = 0;
        int currentTank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];

            if (currentTank < 0) {
                starting_station = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? starting_station : -1;
    }
}
