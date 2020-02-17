package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 12:45
 */
public class T547 {

    // 朋友圈
    // 友谊传递 && M[i][j] 表示i和j是朋友
    // 计算M中所有的朋友圈数量是多少
    public int findCircleNum(int[][] M) {
        // visited数组
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; ++i) {
            if (!visited[i]) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    // 照着朋友的传递关系直接dfs
    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; ++j) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
