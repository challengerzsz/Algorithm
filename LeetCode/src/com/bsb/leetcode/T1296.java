package com.bsb.leetcode;

import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 12:31
 */
public class T1296 {

    // 是否能将nums数组划分为k个一组的连续数组
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        // 小顶堆 每一次poll k个数据 每次poll的时候都需要判断是不是连续的
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            minHeap.offer(num);
        }

        while (!minHeap.isEmpty()) {
            Integer first = minHeap.poll();
            for (int i = 1; i < k; i++) {
                // 从小顶堆中删除以first开始的连续k个数据
                // 这里也想过poll的时候如果重复就继续offer 但是每次offer进去之后优先队列都会进行一次堆排 下次poll的数据一定还是重复的
                // 所以这个方法被抛弃 然后又去看了一下有没有remove之类的操作 果然支持..
                if (!minHeap.remove(first + i)) {
                    // 如果移除失败 说明划分不存在 直接返回 false
                    return false;
                }
            }
        }
        return true;
    }
}
