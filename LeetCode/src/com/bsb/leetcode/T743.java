package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-24 19:05
 */
public class T743 {

    // 网络延迟时间
    // times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间
    // 计算从K发送信号
    private Map<Integer, Integer> map;

    // 74ms 13%时间
    public int networkDelayTime(int[][] times, int N, int K) {
        // 完善邻接矩阵
        // map的key是某个节点 value是某个节点根据times完善的邻居节点数组
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            // 使用List所表示的value 每一项都是一个数组 数组第二项为邻居节点 数组第一项为key到邻居所需要的信号传播时间
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        for (int node : graph.keySet()) {
            // 对每个邻接矩阵的value进行排序
            // 这里的排序依据就是信号从key到邻居节点的时间升序
            graph.get(node).sort(Comparator.comparingInt(a -> a[0]));
        }

        map = new HashMap<>();
        for (int node = 1; node <= N; ++node) map.put(node, Integer.MAX_VALUE);

        dfs(graph, K, 0);

        int res = 0;
        // dfs之后判断map中对应节点是否存在原始初值 如果有初值存在的话证明没有办法使得一个信号在整个图中传递
        // 依照题意返回-1
        for (int temp : map.values()) {
            if (temp == Integer.MAX_VALUE) return -1;
            res = Math.max(res, temp);
        }
        return res;
    }

    /**
     * 这个dfs的思路就是 如果map中有节点的值从Integer.MAX_VALUE更新到了信号传递到它的时间passed
     * 那么如果之后从别的节点的邻接矩阵信息中再次dfs过来的时候就会出现passed > map.get(node)
     * 出现这种情况也可以视为目前这个节点在上一步已经dfs过 其实map也就相当于一个另类的visited数组
     * 但是我们需要在dfs之后统计map中的最大值 也就是信号从K传递完整个图之后的最终费时
     *
     * @param graph  图的邻接矩阵
     * @param node   当前dfs到哪个节点
     * @param passed 信号自发出经过的时间
     */
    public void dfs(Map<Integer, List<int[]>> graph, int node, int passed) {
        if (passed >= map.get(node)) return;
        map.put(node, passed);
        if (graph.containsKey(node))
            for (int[] nextNodeAndTime : graph.get(node))
                dfs(graph, nextNodeAndTime[1], passed + nextNodeAndTime[0]);
    }

    // 弗洛伊德思想
    public int networkDelayTime2(int[][] times, int N, int K) {
        // 完善邻接矩阵
        // map的key是某个节点 value是某个节点根据times完善的邻居节点数组
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            // 使用List所表示的value 每一项都是一个数组 数组第二项为邻居节点 数组第一项为key到邻居所需要的信号传播时间
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        int[][] matrix = new int[N + 1][N + 1];
        for (int[] temp : matrix) Arrays.fill(temp, -1);

        // 填充matrix矩阵
        for (int i = 1; i < matrix.length; ++i) {
            List<int[]> temp = graph.get(i);
            if (temp == null) continue;
            for (int[] tempNeighbour : temp) {
                matrix[i][tempNeighbour[1]] = tempNeighbour[0];
                checkMayChange(matrix, i, tempNeighbour[1], tempNeighbour[0]);
            }
        }
        int countIfNotVisited = 0;
        int max = -1;
        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[K][j] == -1) countIfNotVisited++;
            else max = max > matrix[K][j] ? max : matrix[K][j];
        }
        return countIfNotVisited == 1 ? max : -1;
    }

    private void checkMayChange(int[][] matrix, int node, int end, int val) {
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][end] == -1 && matrix[i][node] != -1) {
                if (i == end) continue;
                matrix[i][end] = matrix[i][node] + val;
            } else if (matrix[i][end] != -1) {
                if (i == node) {
                    for (int j = 1; j < matrix.length; ++j) {
                        if (matrix[i][j] != -1 && matrix[j][end] != -1)
                            matrix[i][end] = Math.min(matrix[i][j] + matrix[j][end], matrix[i][end]);
                    }
                } else {
                    if (matrix[i][node] != -1)
                        matrix[i][end] = Math.min(matrix[i][node] + matrix[node][end], matrix[i][end]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}};
        new T743().networkDelayTime2(times, 3, 1);
//        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
//        new T743().networkDelayTime2(times, 4, 2);
    }
}
