package com.bsb.leetcode.vip.bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 10:41
 */
public class T146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public T146(int capacity) {
        // accessOrder参数表示是否需要根据get方法调整map中节点的位置
        // accessOrder为true的话 get方法会把节点移动至LinkedHashMap双向链表的末尾
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // 重写这个方法之后将删除LinkedHashMap的头节点 因为get操作会把最新访问的节点移动到链表末端
    // 头部自然就是最近最少使用的了
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }

}
