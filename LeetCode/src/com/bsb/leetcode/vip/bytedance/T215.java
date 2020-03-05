package com.bsb.leetcode.vip.bytedance;

import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 18:45
 */
public class T215 {

    // 数组第k大元素
    // 小顶堆
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int index = 0;
        while (index <= nums.length - 1) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[index]);
                index++;
                continue;
            }
            if (minHeap.size() == k && minHeap.peek() < nums[index]) {
                minHeap.poll();
                minHeap.offer(nums[index]);
            }
            index++;
        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        new T215().findKthLargest(array, 4);
    }
}
