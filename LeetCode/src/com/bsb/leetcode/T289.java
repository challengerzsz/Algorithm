package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 20:17
 */
public class T289 {

    // 生命游戏
    // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
    // 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
    // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
    // 给出一轮更新后的board情况
    // 细胞的复活和死亡同时进行
    //  1 —— 继续存活
    // -1 —— 存活变成死亡
    //  0 —— 还是死的没变
    // -2 —— 复活
    public void gameOfLife(int[][] board) {
        // 修改棋盘上细胞的记号
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = helper(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
    }

    public int helper(int[][] board, int i, int j) {
        int count = 0;
        // 四个方向确定边界
        int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[i].length - 1);
        int top = Math.max(i - 1, 0);
        int bottom = Math.min(i + 1, board.length - 1);
        for (int x = top; x <= bottom; x++) {
            for (int y = left; y <= right; y++) {
                // 活死细胞计数
                count = board[x][y] == 1 || board[x][y] == -1 ? count + 1 : count;
            }
        }
        return board[i][j] == 1 ? (count == 3 || count == 4 ? 1 : -1) : (count == 3 ? -2 : 0);
    }
}
