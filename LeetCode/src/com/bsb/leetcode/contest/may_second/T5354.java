package com.bsb.leetcode.contest.may_second;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-08 11:02
 */
public class T5354 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int count = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i == headID) continue;
            int top = manager[i];

            if (set.contains(top)) continue;
            count += informTime[top];
            set.add(top);
        }

        return count;
    }

    // bfs
    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        // 保存每个员工和上级的关系
        List<Integer>[] subs = new List[n];
        for (int i = 0; i < subs.length; i++) {
            subs[i] = new ArrayList<>();
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                subs[manager[i]].add(i);
            }
        }
        // 每个员工收到通知的时间
        int[] timeInformed = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(headID);
        while (!queue.isEmpty()) {
            int parent = queue.remove();
            for (int child : subs[parent]) {
                // 下属收到通知的时间 = 上级收到通知的时间 + 上级通知下属所需时间
                timeInformed[child] = timeInformed[parent] + informTime[parent];
                queue.offer(child);
            }
        }
        // 最晚收到通知员工收到通知的时间就是总时间
        return Arrays.stream(timeInformed).max().getAsInt();
    }

    public static void main(String[] args) {
        new T5354().numOfMinutes(15, 0, new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6},
                new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0});
    }
}
