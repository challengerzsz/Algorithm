package com.bsb.leetcode;

import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 21:44
 */
public class T1046 {

    // 最后一块石头的重量
    // 贪心
    // 每回合挑出最重的两块石头
    // 如果两块石头的重量一致 那就全部完全粉碎
    // 如果有一块石头比较轻 则较重的那块石头将会剩下他俩之间的差值
    // 最后只会剩下一块石头 求这个石头的重量
    // 16% 大顶堆求解 没用贪心思想
    // 看了一下其他人的解 并没有用贪心的思想的 这题目其实主要就是在找当前的最大两块石头 贪心其实没什么可贪的
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int temp : stones) maxHeap.offer(temp);
        while (maxHeap.size() >= 2) {
            int temp1 = maxHeap.poll();
            int temp2 = maxHeap.poll();
            if (temp1 != temp2) {
                maxHeap.offer(Math.abs(temp1 - temp2));
            }
        }
        if (maxHeap.size() == 0) return 0;
        return maxHeap.poll();
    }

}
