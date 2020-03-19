package com.bsb.meituan.spring;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 18:47
 */
public class T4 {
    static class Node {
        int node;
        int dis;

        public Node(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        int dis = scanner.nextInt();
        scanner.close();

        int[][] minDis = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(minDis[i], -1);

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int temp = queue.pollFirst();
            List<Node> list = graph.get(temp);
            for (Node node : list) {
                minDis[temp][node.node] = node.dis;
                helper(minDis, temp, node);
            }
        }

        // 检查最小路径符合的定点 和边


        int count = 0;
        for (int[] temp : minDis) {
            for (int tempI : temp) {
                if (tempI == dis) count++;
            }
        }

        System.out.println(count);
    }

    private static void helper(int[][] minDis, int temp, Node node) {
        for (int i = 1; i < minDis.length; i++) {
            if (i == temp) continue;
            if (minDis[i][node.node] != -1) {
                if (minDis[i][temp] != -1) {
                    minDis[i][node.node] = Math.min(minDis[i][node.node],
                            minDis[i][temp] + minDis[temp][node.node]);
                }
            }
        }
    }
}
