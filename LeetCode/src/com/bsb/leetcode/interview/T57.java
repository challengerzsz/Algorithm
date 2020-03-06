package com.bsb.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-06 15:14
 */
public class T57 {

    // 和为s的连续正数序列
    // 滑动窗口
    // 窗口维护的是一个区间的和的大小
    // 窗口left右移肯定是整个区间和变小了 这也是sum > target之后需要做的操作
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        // 左边数字大于target的一半时必定没有解
        // [left, right)
        while (left <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += right;
                right++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= left++;
            } else {

                int[] temp = new int[right - left];
                for (int i = left; i < right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
                // 左边界向右移动
                sum -= left++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] array = new int[10][];
        for (int[] temp : array) System.out.println(1);
    }
}
