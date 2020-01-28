package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 13:40
 */
public class T130 {

    // 这个题目其实思考之后 就是寻找矩阵四边与字符O连接的O 先用其余字符替代
    // dfs之后把所有的占位符表示的位置还原为O 把剩余的O替换为X
    // 类似最大岛屿
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 判断是否为边界
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }

        // 还原与重制整个矩阵
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // 判断越界条件或者是已经dfs过的点或者是不需要dfs的位置
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }
}
