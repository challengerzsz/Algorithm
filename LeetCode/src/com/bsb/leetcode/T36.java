package com.bsb.leetcode;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 14:29
 */
public class T36 {

    // 7ms 时间击败7.3% :(
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> checkRowSet = new HashSet<>();
        HashSet<Character> checkColSet = new HashSet<>();
        // 检查行 列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && checkRowSet.contains(board[i][j])) {
                    return false;
                }
                checkRowSet.add(board[i][j]);
                if (board[j][i] != '.' && checkColSet.contains(board[j][i])) {
                    return false;
                }
                checkColSet.add(board[j][i]);
            }
            checkColSet.clear();
            checkRowSet.clear();
        }
        // 检查3 * 3小方格
        HashSet<Character> checkBlockSet = new HashSet<>();
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != '.' && checkBlockSet.contains(board[i + k][j + l])) {
                            return false;
                        }
                        checkBlockSet.add(board[i + k][j + l]);
                    }
                }
                checkBlockSet.clear();
            }
        }
        return true;
    }
}
