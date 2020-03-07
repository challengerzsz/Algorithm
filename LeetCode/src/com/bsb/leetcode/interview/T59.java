package com.bsb.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 11:34
 */
public class T59 {

    // 最大队列
    private int index = 0;
    private List<Integer> maxQueue;
    private List<Integer> queue;

    public T59() {
        maxQueue = new ArrayList<>();
        queue = new ArrayList<>();
    }

    public int max_value() {
        if (!maxQueue.isEmpty()) return maxQueue.get(0);
        return -1;
    }

    public void push_back(int value) {
        while (!maxQueue.isEmpty() && value >= maxQueue.get(maxQueue.size() - 1))
            maxQueue.remove(maxQueue.size() - 1);

        maxQueue.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int cur = queue.get(0);
        if (maxQueue.get(0) == cur) maxQueue.remove(0);
        queue.remove(0);
        return cur;
    }
}
