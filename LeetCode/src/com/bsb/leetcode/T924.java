package com.bsb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-28 18:18
 */
public class T924 {

    // 减少恶意软件传播
    // graph[i][j] == 1 表示图中i和j直接相连
    // initial数组标记某些顶点存在恶意软件
    // 直接相连的两个顶点如果其中有一个顶点有恶意软件 那么另一个节点也会被恶意软件传播
    // 假设最终停止传播之后的有恶意软件的节点数为M
    // 删除一个initial中的节点 保证最后病毒不传播之后M值最小
    // dfs + 着色
    public int minMalwareSpread(int[][] graph, int[] initial) {

        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        int colorAndCount = 0;

        // 先着色
        for (int node = 0; node < graph.length; ++node) {

            // 对每一个顶点进行着色 每次对一个新顶点开始dfs着色的时候更换color
            if (colors[node] == -1)
                dfs(graph, colors, node, colorAndCount++);
        }

        // 每种颜色的顶点数量
        int[] everyColorCount = new int[colorAndCount];
        for (int color : colors)
            everyColorCount[color]++;

        // 统计有恶意软件顶点的颜色
        int[] badColorArray = new int[colorAndCount];
        for (int node : initial)
            badColorArray[colors[node]]++;

        int res = Integer.MAX_VALUE;
        for (int node : initial) {
            int color = colors[node];
            // badColorArray在这里表示的是有恶意软件的顶点在着色之后 相同颜色的bad节点数量
            // 如果有一个以上的bad节点颜色为同一个颜色 那么这几个bad节点肯定是处于一个连通分量的
            // 那么如果从这个存在多个bad 节点的连通分量中移除一个bad节点 那么根据连通分量的性质和题目规定
            // 这一整个连通分量是必定到最后会被传染的
            // 所以只需要去考虑那些bad节点只单个存在于某个连通分量中的情况
            // 删除这个只存在于某个连通分量中的bad节点 一定能够保证最后留下最多的未被感染的节点
            if (badColorArray[color] == 1) {
                // 这里是第一次进这个if做的修改
                if (res == Integer.MAX_VALUE)
                    res = node;
                    // 这里是指某一个连通分量中只存在一个bad节点 && 之前得出答案的应该删除的那个bad节点所在的连通分量中顶点数目没有这个多
                    // 那么更新这个res 这个时候留下的肯定是最多的无感染节点
                else if (everyColorCount[color] > everyColorCount[colors[res]])
                    res = node;
                    // 这里需要解决的是如果出现多个bad节点各自存在于一个独立的连通分量之中 且连通分量的节点数目一致
                    // 按照题意返回编号较小的bad节点
                else if (everyColorCount[color] == everyColorCount[colors[res]] && node < res)
                    res = node;
            }
        }

        // 处理如果每个bad节点不符合上面所有情况的解
        if (res == Integer.MAX_VALUE)
            for (int node : initial)
                // 删谁都一样 但是得删顶点编号较小的节点
                res = Math.min(res, node);

        return res;
    }

    public void dfs(int[][] graph, int[] colors, int index, int color) {
        colors[index] = color;
        for (int i = 0; i < graph.length; ++i)
            if (graph[index][i] == 1 && colors[i] == -1)
                dfs(graph, colors, i, color);
    }


    // 并查集替代染色 找所有的连通分量
    // 这题其实就是说给你一个图
    // 其中有些节点是被电脑病毒感染的节点
    // 现在只能删除一个节点 问你删除哪个节点能够让整个图中存留的未感染数量最大
    // 回顾了一下连通分量这个概念 其实这个题目意思就是
    // 找出某一个最大的连通分量 && 这个连通分量中只存在一个感染了病毒的电脑
    // 删掉这个被感染的电脑即可
    class UnionSet {
        int[] array;
        int[] count;

        UnionSet(int size) {
            array = new int[size];
            count = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = -1;
                count[i] = 1;
            }
        }

        int find(int x) {
            while (array[x] >= 0) {
                x = array[x];
            }
            return x;
        }

        // 两集合中较少元素的集合合并到较大数量元素的集合中
        void union(int x, int y) {
            if (x == y)
                return;
            if (count[x] > count[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            count[y] += count[x];
            array[x] = y;
        }

        int getCount(int x) {
            return count[x];
        }
    }

    public int minMalwareSpread2(int[][] graph, int[] initial) {

        Arrays.sort(initial);

        UnionSet unionSet = new UnionSet(graph.length);
        for (int i = 0; i < graph.length; i++) {
            // 这里是因为给定的graph这个二维数组中的对角线是自己到自己的边 所以这里直接j = i + 1只考虑上半部分
            for (int j = i + 1; j < graph[0].length; j++) {
                // 如果两节点之间连通
                if (graph[i][j] != 0) {
                    // 寻找两个顶点在并查集中的root节点
                    int rootI = unionSet.find(i), rootJ = unionSet.find(j);
                    // 合并
                    unionSet.union(rootI, rootJ);
                }
            }
        }

        // 从并查集中找恶意节点是否可能存在于一个连同分量中
        // 如果map<key, -1>则证明当前这个key的连同分量至少有2个恶意节点
        // important : 如果map中的某个恶意节点在并查集中的root在map中的值不为-1  则证明该连通分量最多存在一个恶意节点
        // 统计上面important条目的连同分量 判断只存在一个恶意节点的连同分量 哪个的节点数多 那么删掉某个多顶点的连同分量中的恶意节点
        // 就能保存下来最多未被感染的节点
        Map<Integer, Integer> map = new HashMap<>();
        for (int index : initial) {
            int root = unionSet.find(index);
            if (map.containsKey(root))
                map.put(root, -1);
            else {
                map.put(root, index);
            }
        }
        int max = -1, result = initial[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int root = entry.getKey();
            int index = entry.getValue();
            if (index == -1)
                continue;
            int count = unionSet.getCount(root);
            if (count > max || (count == max && index < result)) {
                max = count;
                result = index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 0, 0, 0, 1}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, {0, 1, 1, 1, 1, 0, 1, 0, 0, 1}};
        int[] badNode = new int[]{9, 0, 2};

        new T924().minMalwareSpread(graph, badNode);
    }
}
