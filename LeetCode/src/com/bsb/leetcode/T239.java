package com.bsb.leetcode;

import java.util.ArrayDeque;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 16:22
 */
public class T239 {

    // 滑动窗口最大值
    // 题目直接要求限行时间复杂度
    // 优化这个时间复杂度的话肯定是使用堆了 维护一个大小为k的大顶堆 去计算 时间复杂福O(nlogk)
    // 暴力解 枚举所有窗口大小为k的窗口 计算每个窗口的最大值 最后加入结果
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        // 只能有n - k + 1个窗口
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) max = Math.max(max, nums[j]);
            res[i] = max;
        }
        return res;
    }

    // 双端队列 优化时间复杂度
    // 只保留当前滑动窗口中有的元素的索引
    // 移除比当前元素小的所有元素，它们不可能是最大的
    private ArrayDeque<Integer> dequeue = new ArrayDeque<>();
    int[] nums;

    public void cleanDequeue(int i, int k) {
        if (!dequeue.isEmpty() && dequeue.getFirst() == i - k)
            dequeue.removeFirst();

        while (!dequeue.isEmpty() && nums[i] > nums[dequeue.getLast()]) dequeue.removeLast();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        this.nums = nums;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            cleanDequeue(i, k);
            dequeue.addLast(i);
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[maxIndex];

        for (int i = k; i < n; i++) {
            cleanDequeue(i, k);
            dequeue.addLast(i);
            res[i - k + 1] = nums[dequeue.getFirst()];
        }
        return res;
    }

    // 动态规划解
    // 之前有想过用一维dp数组求解 但是状态的转移一开始的思路都是从左到右
    // 这样的话就没有办法维护一个滑动窗口之内的次大值 所以一旦窗口发生变化 一维数组也没办法解决
    // 这里维护两个数组 left 和 right数组
    // 将nums分成k份 left数组从左至右扫描 记录每个块内的最大值在left数组的右侧
    // right数组从右至左扫描 将每个块的最大值记录在right数组的左侧
    // 针对i～j的窗口
    // right[i]是窗口位于最左侧块内的最大值 left[j]是窗口位于最右侧块内的最大值
    // 这样的话就可以解决这个题目了
    public int[] maxSlidingWindowByDp(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // 从左至右
            if (i % k == 0) left[i] = nums[i]; 
            else left[i] = Math.max(left[i - 1], nums[i]);

            // 从右至左
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j]; 
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] res = new int[n - k + 1];
        // n - k + 1种窗口位置
        for (int i = 0; i < n - k + 1; i++)
            res[i] = Math.max(left[i + k - 1], right[i]);

        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        new T239().maxSlidingWindow2(array, 3);
    }
}
