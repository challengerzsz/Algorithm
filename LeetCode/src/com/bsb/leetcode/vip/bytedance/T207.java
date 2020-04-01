package com.bsb.leetcode.vip.bytedance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-01 20:44
 */
public class T207 {

    // 课程表
    // 其实就是检测DGA是否有环路存在 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表
        int[] inDegree = new int[numCourses];
        for (int[] temp : prerequisites) {
            // 学temp[0] 必须学 temp[1]
            // temp[1]就是一个指向temp[0]的顶点
            inDegree[temp[0]]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offerLast(i);
        }
        while (!queue.isEmpty()) {
            int head = queue.pollFirst();
            // 这里的head其实就是拓扑排序的结果
            // 这里是对拓扑排序进行改进来实现环路判断
            // O(n)
            numCourses--;
            for (int[] temp : prerequisites) {
                if (temp[1] != head) continue;
                if (--inDegree[temp[0]] == 0) queue.offerLast(temp[0]);
            }
        }
        return numCourses == 0;
    }
}
