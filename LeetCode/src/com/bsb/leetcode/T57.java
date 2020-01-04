package com.bsb.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-04 15:50
 */
public class T57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 和上一题意思其实差不多 就是在处理上不一致
        int[][] newIntervals = new int[intervals.length + 1][];
        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);
        newIntervals[intervals.length] = newInterval;

        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> stack = new Stack<>();
        for (int[] num : newIntervals) {
            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            int[] arr = stack.peek();
            if (arr[1] >= num[0]) {
                int[] combine = {arr[0], Math.max(arr[1], num[1])};
                stack.pop();
                stack.push(combine);
            } else {
                stack.push(num);
            }
        }
        return stack.toArray(new int[0][]);
    }
}
