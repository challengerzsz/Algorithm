package com.bsb.leetcode;

import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 20:31
 */
public class T120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) return 0;
        int count = 0;
        int level = 1;
        int lastIndex = 0;
        count += triangle.get(0).get(0);
        int a, b;
        while (level < triangle.size()) {
            a = triangle.get(level).get(lastIndex);
            b = triangle.get(level).get(lastIndex + 1);
            int minIndex = a > b ? (lastIndex = lastIndex + 1) : (lastIndex = lastIndex);
            count += triangle.get(level).get(minIndex);
            level++;
        }
        return count;
    }

    // 动态规划解
    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] min = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                // 第i行有i+1个数字
                min[i] = Math.min(min[i], min[i + 1]) + triangle.get(level).get(i);
            }
        }
        return min[0];
    }

    // 自底向上 一维数组解决这个问题
    // dp[i]表示走到某行的第i个位置的时候的最小值
    public int minimumTotal3(List<List<Integer>> triangle) {

        int size = triangle.size();
        int[] dp = new int[size];

        // 从三角形的最后一行数组初始化dp[i]
        // 因为自底向上 所以初始化dp的时候思路也不一样
        List<Integer> last = triangle.get(size - 1);
        for (int i = 0; i < size; i++)
            dp[i] = last.get(i);

        // 从倒数第2行开始向上寻找最小路径
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                // 从刚才dp累加的最小和选择最小
                // 这里j和j + 1其实就是能够允许跨行走的路径方向
                dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        // 自底向上完了之后dp[0]的位置就是整个金字塔中最小的路径和
        return dp[0];
    }
}
