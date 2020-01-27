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
}
