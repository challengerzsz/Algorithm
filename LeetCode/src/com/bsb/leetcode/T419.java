package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-02 21:46
 */
public class T419 {

    // 计算甲板上的战舰
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    boolean isShip = true;
                    if (i != 0) {
                        if (board[i - 1][j] == 'X') {
                            isShip = false;
                        }
                    }
                    if (j != 0) {
                        if (board[i][j - 1] == 'X') {
                            isShip = false;
                        }
                    }
                    if (isShip) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
