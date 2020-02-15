package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 21:08
 */
public class T526 {

    // 优美的排列
    // 第 i 位的数字能被 i 整除
    // i 能被第 i 位上的数字整除
    // 思路就是回溯法，与全排列等同
    // dfs搜索，每前进一步，必须满足两个条件之一，分情况往下走(全排列问题)
    int count = 0;

    public int countArrangement(int N) {
        int[] visited = new int[N + 1];
        // 这里从1开始 0不能作为除数
        backTraceHelper(1, N, visited);
        return count;
    }

    private void backTraceHelper(int num, int N, int[] visited) {
        if (num == N + 1) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                // 剪枝
                if (i % num == 0 || num % i == 0) {
                    backTraceHelper(num + 1, N, visited);
                }
                visited[i] = 0;
            }
        }
    }
}
