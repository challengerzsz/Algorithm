package com.bsb.leetcode.tag.bytedane.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 20:56
 */
public class T5 {

    // 第k大元素
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
        int len = nums.length;
        // 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(len);
        for (int i = 0; i < len; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            heap.poll();
        }
        return heap.peek();
    }
}