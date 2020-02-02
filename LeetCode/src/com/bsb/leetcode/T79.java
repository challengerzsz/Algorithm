package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-02 18:01
 */
public class T79 {

    // 其实就是标准的DFS 这题目描述的有点问题 容易误解
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row < 1 || word.length() < 1) return false;
        int col = board[0].length;
        if (col * row < word.length()) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char temp = board[i][j];
                    // 修改临时的值 避免重复访问
                    board[i][j] = '.'; 
                    if (helper(board, word, 1, i, j, row, col, word.length())) return true;
                    board[i][j] = temp;
                }
            }
        }

        return false;
    }
    
    private boolean helper(char[][] board, String word, int index, int startRow, int startCol, 
                           int row, int col, int length) {
        if (index > length - 1) return true;
        // 向右
        if (startCol < col - 1 && word.charAt(index) == board[startRow][startCol + 1]) {
            char temp = board[startRow][startCol + 1];
            board[startRow][startCol + 1] = '.';
            if (helper(board, word, index + 1, startRow, startCol + 1, row, col, length)) return true;
            board[startRow][startCol + 1] = temp;
        }
        // 向下
        if (startRow < row - 1 && word.charAt(index) == board[startRow + 1][startCol]) {
            char temp = board[startRow + 1][startCol];
            board[startRow + 1][startCol] = '.';
            if (helper(board, word, index + 1, startRow + 1, startCol, row, col, length)) return true;
            board[startRow + 1][startCol] = temp;
        }
        // 向左
        if (startCol > 0 && word.charAt(index) == board[startRow][startCol - 1]) {
            char temp = board[startRow][startCol - 1];
            board[startRow][startCol - 1] = '.';
            if (helper(board, word, index + 1, startRow, startCol - 1, row, col, length)) return true;
            board[startRow][startCol - 1] = temp;
        }
        // 向上
        if (startRow > 0 && word.charAt(index) == board[startRow - 1][startCol]) {
            char temp = board[startRow - 1][startCol];
            board[startRow - 1][startCol] = '.';
            if (helper(board, word, index + 1, startRow - 1, startCol, row, col, length)) return true;
            board[startRow - 1][startCol] = temp;
        }

        return false;
    }
}
