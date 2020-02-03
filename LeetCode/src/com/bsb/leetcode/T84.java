package com.bsb.leetcode;

import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 16:30
 */
public class T84 {

    // 两两组合 找最低的高度 计算面积
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, min * (j - i + 1));
            }
        }
        return max;
    }

    // 分治 把每一个高度作为最小 左右拓展
    public int largestRectangleArea2(int[] heights) {
        return help(heights, 0, heights.length - 1);
    }

    public int help(int[] heights, int start, int end) {
        if (start > end) return 0;
        int minIndex = start;
        for (int i = start; i <= end; i++)
            if (heights[minIndex] > heights[i]) minIndex = i;
        return Math.max(heights[minIndex] * (end - start + 1), Math.max(help(heights, start, minIndex - 1),
                help(heights, minIndex + 1, end)));
    }

    // 栈
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }

}
