package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-09 23:22
 */
public class T79 {

    private boolean res = false;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length && !res; i++) {
            for (int j = 0; j < board[0].length && !res; j++) {
                if (board[i][j] == word.charAt(0)) {
                    helper(board, i, j, 0, word, visited);
                }
            }
        }

        return res;
    }

    private void helper(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            res = true;
            return;
        }
        if (res || i < 0 || i >= board.length || j < 0 || j > board[0].length || visited[i][j]
                || board[i][j] != word.charAt(index)) return;


        visited[i][j] = true;

        for (int[] dir : directions) {
            helper(board, i + dir[0], j + dir[1], index + 1, word, visited);
        }

        visited[i][j] = false;
    }
}
