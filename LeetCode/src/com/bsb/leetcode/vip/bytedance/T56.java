package com.bsb.leetcode.vip.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 18:15
 */
public class T56 {

    // 合并区间
    // 每次尽量拓展右边界
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return 1;
            }
        });
        int start = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) right = Math.max(intervals[i][1], right);
            else {
                res.add(new int[]{start, right});
                start = intervals[i][0];
                right = intervals[i][1];
            }
        }

        // 最后一个start和end对没有在循环存上
        res.add(new int[]{start, right});

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3}, {1, 2}, {8, 10}, {15, 18}};
        new T56().merge(array);
    }
}
