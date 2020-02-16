package com.bsb.leetcode.contest.seventeenth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 10:53
 */
public class T3 {

    // 最多能参加的会议
    // 贪心 把最早开始的会议先安排
    // 这思路直接就错了 后来想了一下 应该最先安排起始时间和终止时间间隔最短的会议
    // 解答错误
    public int maxEvents(int[][] events) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        // 按照会议持续天数排序
        Arrays.sort(events, Comparator.comparingInt(o -> (o[1] - o[0])));
        for (int i = 0; i < events.length; i++) {
            if (!set.contains(events[i][0])) {
                res++;
                set.add(events[i][0]);
            } else {
                for (int j = events[i][0] + 1; j <= events[i][1]; j++) {
                    if (!set.contains(j)) {
                        res++;
                        set.add(j);
                        break;
                    }
                }
            }
        }
        return res;
    }

    // 按照结束时间进行排序
    // 直接扫一遍 只需要注意看看在当前会议时间能否安排 注意isArranged数组
    public int maxEvents2(int[][] events) {
        Arrays.sort(events, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        boolean[] isArranged = new boolean[100005];
        int res = 0;
        for (int[] temp : events) {
            for (int i = temp[0]; i <= temp[1]; i++) {
                if (isArranged[i] == false) {
                    isArranged[i] = true;
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] array = {{1, 1}, {1, 2}, {1, 7}, {3, 3}};
        Arrays.sort(array, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        System.out.println(new T3().maxEvents(array));
    }
}
