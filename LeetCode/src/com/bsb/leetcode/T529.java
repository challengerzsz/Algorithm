package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 20:37
 */
public class T529 {

    // 扫雷游戏
    // 这里新增4个方向 表示相邻对角点
    private int[][] directions = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        // 如果这一次的点击直接点雷上了 直接修改M -> X
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        dfs(board, row, col);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (checkIfInArea(board, i, j) && board[i][j] == 'E') {
            int count = 0;
            for (int[] tempDirection : directions) {
                int row = i + tempDirection[0], col = j + tempDirection[1];
                // 统计雷和必要的四周距离
                if (checkIfInArea(board, row, col) && (board[row][col] == 'M' || board[row][col] == 'X')) {
                    count++;
                }
            }
            if (count > 0) {
                // 这里必须这么做 按ASCII转的 如果不加'0'的ASCII直接转出来就不是我想要的
                board[i][j] = (char) (count + '0');
                return;
            }
            board[i][j] = 'B';
            for (int[] dir : directions) {
                int row = i + dir[0], col = j + dir[1];
                
                if (checkIfInArea(board, row, col) && board[row][col] == 'E') {
                    dfs(board, row, col);
                }
            }
        }
    }

    // 越界检测
    private boolean checkIfInArea(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
