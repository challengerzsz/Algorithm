package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-12 9:33
 */
public class T133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // 给一个图 返回这个图的深拷贝
    public Node cloneGraph(Node node) {
        // map保存原始顶点和深拷贝的新顶点的关系
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        // 如果在某个顶点dfs的时候其中的邻居顶点已经被创建过 那就直接拿走
        // 有点像复制带random指针的链表
        if (map.containsKey(node)) return map.get(node);
        // 其实深拷贝应该是Node实现Cloneable接口在clone方法重写实现深拷贝的..但是这里我试了一下确实可以
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for (Node temp : node.neighbors) clone.neighbors.add(dfs(temp, map));
        return clone;
    }


    // BFS广搜
    public Node cloneGraph2(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        // 直接克隆给定的一个顶点和他的邻接list
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);

        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node tempNode : temp.neighbors) {
                if (!map.containsKey(tempNode)) {
                    map.put(tempNode, new Node(tempNode.val, new ArrayList<>()));
                    queue.offer(tempNode);
                }
                // 给队列中poll出来的克隆顶点完善它的邻接list
                map.get(temp).neighbors.add(map.get(tempNode));
            }
        }
        return clone;
    }
}
