package com.bsb.test;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-06 15:02
 */
public class Test4 {

    public List<Integer> findTopK(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计频率
        for (int temp: array) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        // 优先队列
        // 匿名对象 lambda表达式
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int temp: map.keySet()) {
            heap.add(temp);
            // 维护小顶堆和topk的关系
            if (heap.size() > k) heap.poll();
        }

        List<Integer> res = new LinkedList<>();
        while (!heap.isEmpty()) res.add(heap.poll());
        // 这里需要反转 因为是小顶堆
        Collections.reverse(res);
        return res;
    }


}
