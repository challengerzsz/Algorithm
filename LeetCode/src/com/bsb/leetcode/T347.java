package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-31 11:23
 */
public class T347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int temp: nums) {

            // getOrDefault 这个api后来发现 马住
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        // 优先队列
        // Comparator.comparingInt(map::get) 这个是idea生成的lambda表达式.. 其实就是一个匿名对象
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int temp: map.keySet()) {
            heap.add(temp);
            // 维护小顶堆和topk的关系
            if (heap.size() > k) heap.poll();
        }

        List<Integer> res = new LinkedList<>();
        while (!heap.isEmpty()) res.add(heap.poll());
        // 这里需要反转 因为是小顶堆 题目需要的是topk..
        Collections.reverse(res);
        return res;
    }
}
