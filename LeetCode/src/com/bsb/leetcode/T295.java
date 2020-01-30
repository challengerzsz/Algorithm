package com.bsb.leetcode;

import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 18:20
 */
public class T295 {

    // 这题一看就是大小顶堆 这题就是利用两个集合类不停的调整堆寻找中位数
    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    public T295() {
        count = 0;
        // lambda表达式传入Comparator匿名对象
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());

        // 如果两个堆合起来的元素个数是奇数
        // 小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        // 通过count判断是两个堆顶元素怎么计算中位数
        if ((count & 1) == 0) {
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {
            return (double) maxheap.peek();
        }
    }
}
