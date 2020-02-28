package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-28 10:09
 */
public class T886 {

    // 可能的二分法
    // 每个人分入任意大小的两个group
    // dislikes数组每一项表示两个互不喜欢的人 不能分入一组
    // dfs + 着色
    List<List<Integer>> graph = new LinkedList<>();
    private int[] color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        color = new int[N];
        for (int i = 0; i < N; i++) {
            graph.add(new LinkedList<>());
        }
        // 其实这里填充出来的graph就是一个无向图
        for (int i = 0; i < dislikes.length; i++) {
            // -1是因为每个人的序号和数组序号对应
            graph.get(dislikes[i][0] - 1).add(dislikes[i][1] - 1);
            graph.get(dislikes[i][1] - 1).add(dislikes[i][0] - 1);
        }
        for (int i = 0; i < N; i++) {
            // 尝试给某个顶点着色 前提是color[i] == 0 表示未着色
            // 两个分组的color分别为1 和 -1
            if (color[i] == 0 && !dfs(i, 1)) return false;
        }

        return true;
    }

    public boolean dfs(int index, int colors) {
        color[index] = colors;
        for (int i = 0; i < graph.get(index).size(); i++) {
            // 找index的邻接节点
            int j = graph.get(index).get(i);
            if (color[j] == colors) return false;
            // 每一条边都是一条dislike的边 所以这里给找到的顶点直接着色-color
            if (color[j] == 0 && !dfs(j, -colors)) return false;
        }
        return true;
    }
}
