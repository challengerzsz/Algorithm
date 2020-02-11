package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-11 18:18
 */
public class T329 {

    // 矩阵中最长的上升序列
    // dfs系列
    public int res = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j, Integer.MIN_VALUE, 1);
            }
        }
        return res;
    }

    // 超时..
    // 135/138 差3个用例
    private void dfs(int[][] matrix, int i, int j, int pre, int now) {
        // 处理边界条件
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return;

        if (matrix[i][j] > pre) res = Math.max(res, now);
        else return;

        dfs(matrix, i - 1, j, matrix[i][j], now + 1);
        dfs(matrix, i, j - 1, matrix[i][j], now + 1);
        dfs(matrix, i, j + 1, matrix[i][j], now + 1);
        dfs(matrix, i + 1, j, matrix[i][j], now + 1);

    }


    // dfs + 记忆化 避免过多重复计算
    // 记忆化的意思就是从目前节点开始dfs 并且缓存向上下左右递归之后的结果
    // 下一步dfs到该节点的时候如果四周的结果已经存在与cache中 就直接取 不需要在进行dfs递归
    // 方向数组
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs2(matrix, i, j, cache));
        return ans;
    }

    private int dfs2(int[][] matrix, int i, int j, int[][] cache) {
        // 如果cache有之前dfs的结果就直接返回 不需要继续dfs
        if (cache[i][j] != 0) return cache[i][j];
        // 遍历四种方向的数组
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs2(matrix, x, y, cache));
        }
        return ++cache[i][j];
    }

    // 还有一种"动态规划"的解 依赖拓扑排序的思路 那个解我看了一下有点太难理解
}
