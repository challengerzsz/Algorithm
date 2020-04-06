package com.bsb.bytedance.prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-06 10:18
 */
public class T57 {

    // hard 插入区间
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);

        list.sort(Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            if (end >= list.get(i)[0]) {
                if (end >= list.get(i)[1]) continue;
                end = list.get(i)[1];
            } else {
                res.add(new int[]{start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }

        res.add(new int[]{start, end});
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        new T57().insert(intervals, new int[]{2, 3});
    }
}
