package com.bsb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-11 16:01
 */
public class T207 {

    // 课程表
    // 在选修某些课程之前需要一些先修课程 例如想要学习课程0 你需要先完成课程1 我们用一个匹配来表示他们[0,1]
    // 判断这个图是不是有向无环图 一旦出现环那么一定是不能够把所有课程学完
    // 因为题目给定的课程的先后顺序是根据一个二维数组组成 按照题目来说给的是一个边缘列表 其实就是一个课程约束对
    // 按照邻接矩阵直接来dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        // 这里需要创建一个邻接矩阵 邻接矩阵的功能就是为了表示能够从某一个节点dfs到下一个节点是哪些
        int[][] adjacencyMatrix = new int[numCourses][numCourses];
        for (int[] temp : prerequisites) {
            adjacencyMatrix[temp[0]][temp[1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjacencyMatrix, flag)) return false;
        }
        return true;
    }

    private boolean dfs(int i, int[][] adjacencyMatrix, int[] flag) {
        // flag 在这里有3种情况
        // 1、 flag[i] == 0的时候 说明该节点没有任何一次dfs扫描到它
        // 2、 flag[i] == 1的时候证明本次dfs到该节点的时候上层dfs已经深搜到它了 这个时候就已经构成环了 所以直接返回false
        // 3、 flag[i] == -1的时候证明之前已经有不论以哪个节点为开始的dfs已经搜过它了 并且并没有构成环 所以就不用再对该节点深搜了
        if (flag[i] == 1) return false;
        if (flag[i] == -1) return true;
        flag[i] = 1;
        for (int j = 0; j < adjacencyMatrix[0].length; j++) {
            if (adjacencyMatrix[i][j] == 1 && !dfs(j, adjacencyMatrix, flag)) return false;
        }
        flag[i] = -1;
        return true;
    }


    // 拓扑排序 广搜BFS实现
    // 思路是通过 拓扑排序 判断此课程安排图是否是 有向无环图(DAG)。
    // 拓扑排序是对 DAG 的顶点进行排序，使得对每一条有向边 (u, v)(u,v)，均有 u（在排序记录中）比 v 先出现
    // 可理解为对某点 v 而言，只有当 v 的所有源点均出现了，v 才能出现
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
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
            numCourses--;
            for (int[] temp : prerequisites) {
                if (temp[1] != head) continue;
                if (--inDegree[temp[0]] == 0) queue.offerLast(temp[0]);
            }
        }
        return numCourses == 0;
    }
}
