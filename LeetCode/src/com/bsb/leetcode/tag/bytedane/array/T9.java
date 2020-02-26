package com.bsb.leetcode.tag.bytedane.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-26 16:17
 */
public class T9 {

    // 合并区间
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int index = 0;
        while (index < intervals.length) {
            int left = intervals[index][0];
            int right = intervals[index][1];

            while (index < intervals.length - 1 && right >= intervals[index + 1][0]) {
                index++;
                right = Math.max(right, intervals[index][1]);
            }
            res.add(new int[] {left, right});
            index++;
        }
        return res.toArray(new int[0][]);
    }
}
