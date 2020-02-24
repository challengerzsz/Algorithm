package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-24 11:15
 */
public class T576 {

    // 出界的路径数
    // m * n的网格 球一开始是在[i, j] 最多移动N次 求能够把球移出界的路径数量
    // 结果 mod 10^9 + 7
    private long res = 0;

    public int findPaths(int m, int n, int N, int i, int j) {
        boolean[][] visited = new boolean[m][n];
        helper(m, n, N, i, j, 0, visited);
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    private void helper(int m, int n, int N, int i, int j, int step, boolean[][] visited) {
        if (i < 0 || i == m || j < 0 || j == n || visited[i][j]) return;
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && step < N) {
            if ((i == 0 && j == 0) || (i == m - 1 && j == n - 1)
                    || (i == 0 && j == n - 1) || (j == 0 && i == m - 1)) res += 2;
            else res++;
        }

        visited[i][j] = true;

        helper(m, n, N, i + 1, j, step + 1, visited);
        helper(m, n, N, i - 1, j, step + 1, visited);
        helper(m, n, N, i, j + 1, step + 1, visited);
        helper(m, n, N, i, j - 1, step + 1, visited);

        visited[i][j] = false;
    }

    // dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1] + dp[i][j+1][k-1];
    public int findPathsByDp(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        // 取模
        int mod = 1000000007;
        // dp[i][j][k] 表示[i, j]在k之内能够将球移出边界的路径和
        int[][][] dp = new int[m][n][N + 1];

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 这里其实就是最经典的状态枚举框架
        // 每层循环代表一种状态
        // 每层循环都枚举出来可能的情况
        for (int k = 1; k <= N; ++k) {
            for (int x = 0; x < m; ++x) {
                for (int y = 0; y < n; ++y) {
                    for (int[] direction : directions) {
                        int nx = x + direction[0];
                        int ny = y + direction[1];
                        // 边界处理, 无论在第几步只要位置处于边界都包含一步出界的情况
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                            dp[x][y][k] += 1;
                        else
                            // 每一步取模
                            dp[x][y][k] = (dp[x][y][k] + dp[nx][ny][k - 1]) % mod;
                    }
                }
            }
        }

        return dp[i][j][N];
    }

    public static void main(String[] args) {
        new T576().findPaths(2, 2, 2, 0, 0);
    }
}
