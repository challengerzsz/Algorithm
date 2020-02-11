package com.bsb.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-11 19:10
 */
public class T332 {

    // 重新安排行程
    // 要求起点必须是"JFK"
    // 求一个连通图可能的欧拉路径
    // 一个连通有向图 G 有欧拉路径，指存在一个顶点，从它出发，沿着有向边的方向，可以不重复地遍历图中所有的边
    // 因为这个题的题意要求每个路线都必须兼顾
    // 并且还必须路径的选择要选择字典序较小的优先考虑
    // 因为要找到一条最小字典序的欧拉路径 有点贪心的意思 每dfs到图的一个顶点的时候都选择邻接的最小字典序的节点访问
    // 但是这样可能不正确 因为有可能这不是欧拉路径 有可能在这种"最优选择"下不一定能走完整个图
    public List findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) return ans;
        // graph存储顶点和邻接点的关系 也就是保存整个图
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            // 下面的lambda表达式意思是如果当前顶点没有在map中存在 将一个新的链表作为顶点对应的value 保存邻接顶点信息
            List neighbour = graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>());
            neighbour.add(pair.get(1));
        }
        // 对map的所有value 也就是顶点对应的每一个LinkedList按照字典序排序
        graph.values().forEach(x -> x.sort(String::compareTo));
        visit(graph, "JFK", ans);
        return ans;
    }

    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, List<String>> graph, String start, List ans) {
        List neighbour = graph.get(start);
        while (neighbour != null && neighbour.size() > 0) {
            String dest = (String) neighbour.remove(0);
            visit(graph, dest, ans);
        }
        // 这里需要保证逆序插入 因为只有这样才能够解决上面说到的用贪心策略去求欧拉路径的时候不会导致保证最小字典序的情况下求欧拉路径失败
        // 其实这里的处理就是相当于先走了别的路径 但是这个别的路径确保了能找到欧拉路径.. 这里是最不可能想到的地方
        ans.add(0, start);
    }
}
