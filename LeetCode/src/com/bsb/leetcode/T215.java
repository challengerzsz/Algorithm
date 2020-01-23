package com.bsb.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-23 16:32
 */
public class T215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        // 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(len, Comparator.comparingInt(a -> a));
        for (int i = 0; i < len; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            heap.poll();
        }
        return heap.peek();
    }


}
