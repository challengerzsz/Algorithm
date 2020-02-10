package com.bsb.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 20:47
 */
public class T1029 {

    // 两地调度
    // 一共2N个人 要求AB各N人去 并且需要最小花费
    // 按照两地派遣费用差值排序
    // 去往A市的花费-去往B市的花费较小的N个人去A市
    // 因为剩下的N个人如果一开始把他们送往B的话 再调整到A的话 公司将会花费多余前N个人
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        int ans = 0, len = costs.length;
        for (int i = 0; i < len; i++) {
            // 先优先安排去A市
            // 当超过N的时候安排去B市
            ans += costs[i][i < len / 2 ? 0 : 1];
        }
        return ans;
    }
}
