package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-11 16:57
 */
public class T210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[0];
        List<Integer> tempList = new ArrayList<>();
        // 入度表
        int[] inDegree = new int[numCourses];
        for (int[] temp : prerequisites) {
            inDegree[temp[0]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offerLast(i);
        }
        while (!queue.isEmpty()) {
            int head = queue.pollFirst();
            // 这里对课程总数--的含义就是拓扑排序已经完成的次数
            // 对这个题目来说其实也就是该节点不存在dfs成的环
            // 更简单的理解就是该课程不会因为循环前置课程而导致无法学习
            tempList.add(head);
            numCourses--;
            for (int[] temp : prerequisites) {
                if (temp[1] != head) continue;
                if (--inDegree[temp[0]] == 0) queue.offerLast(temp[0]);
            }
        }
        if (numCourses == 0) {
            res = new int[tempList.size()];
            for (int i = 0; i < tempList.size(); i++) {
                res[i] = tempList.get(i);
            }
        }
        return res;
    }


}
