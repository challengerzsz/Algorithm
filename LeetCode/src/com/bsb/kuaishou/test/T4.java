package com.bsb.kuaishou.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 15:48
 */
public class T4 {

    public int GetMaxStaffs(char[][] pos) {
        // write code here
        if (pos == null || pos.length == 0) return 0;

        int res = 0;
        int[][] dp = new int[pos.length][pos[0].length];
        dp[0][0] = pos[0][0] == '*' ? 0 : 1;

        // 第一列
        for (int i = 1; i < pos.length; i++) {
            if (pos[i][0] == '.' && dp[i - 1][0] == 0) {
                dp[i][0] = 1;
                res++;
            }
        }

        // 第一行
        for (int i = 1; i < pos[0].length; i++) {
            if (pos[0][i] == '.' && dp[0][i - 1] == 0) {
                dp[0][i] = 1;
                res++;
            }
        }

        // 最后一行
        for (int i = 1; i < pos[0].length; i++) {
            if (pos[pos.length - 1][i] == '.' && dp[pos.length - 1][i - 1] == 0) {
                dp[pos.length - 1][i] = 1;
                res++;
            }
        }

        // 最后一列
        for (int i = 1; i < pos.length - 2; i++) {
            if (pos[i][pos[0].length - 1] == '.' && dp[i - 1][pos[0].length - 1] == 0
                    && dp[i + 1][pos[0].length - 1] == 0) {
                dp[i][pos[0].length - 1] = 1;
                res++;
            }
        }

        for (int i = 1; i < pos.length - 1; i++) {
            for (int j = 1; j < pos[0].length - 1; j++) {
                if (pos[i][j] == '*') dp[i][j] = 0;
                else {
                    if (dp[i - 1][j] != 1 && dp[i + 1][j] != 1 && dp[i][j - 1] != 0 && dp[i][j + 1] != 1) {
                        dp[i][j] = 1;
                        res++;
                    }
                }
            }
        }

        return res;
    }

    int[][] directions = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    // bfs
    public int GetMaxStaffs2(char[][] pos) {
        if (pos == null || pos.length == 0) return 0;
        int res = 0;
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[pos.length][pos[0].length];

        if (pos[0][0] == '.') {
            queue.offer(new int[]{0, 0});
            visited[0][0] = true;
            res++;
        }
        for (int i = 1; i < pos[0].length; i++) {

            // 第一行
            if (pos[0][i] == '.' && !visited[0][i - 1]) {
                queue.offer(new int[]{0, i});
                res++;
                visited[0][i] = true;
            }

            // 最后一行
            if (pos[pos.length - 1][i] == '.' && !visited[pos.length - 1][i - 1]) {
                queue.offer(new int[]{pos.length - 1, i});
                res++;
                visited[pos.length - 1][i] = true;
            }
        }
        for (int i = 1; i < pos.length - 1; i++) {
            // 第一列
            if (pos[i][0] == '.' && !visited[i - 1][0] && !visited[i + 1][0]) {
                queue.offer(new int[]{i, 0});
                visited[i - 1][0] = true;
                res++;
            }

            // 最后一列
            if (pos[i][pos[0].length - 1] == '.' && !visited[i - 1][pos[0].length - 1] && !visited[i + 1][pos[0].length - 1]) {
                queue.offer(new int[]{i, pos[0].length - 1});
                visited[i][pos[0].length - 1] = true;
                res++;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            for (int[] temp : directions) {
                int x = cur[0] + temp[0];
                int y = cur[1] + temp[1];
                if (x < 0 || x >= pos.length || y < 0 || y >= pos[0].length) continue;
                if (pos[x][y] == '.' && !visited[x][y]) {
                    visited[x][y] = true;
                    res++;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {

//        {'*', '.', '*', '*', '.'}, {'*', '.', '*', '*', '*'}, {'*', '.', '*', '*', '.'}
        System.out.println(new T4().GetMaxStaffs2(new char[][]{
//                {'*', '*'}, {'*', '*'}
                {'*', '.', '*', '*', '.'}, {'*', '.', '*', '*', '*'}, {'*', '.', '*', '*', '.'}
        }));
    }
}
