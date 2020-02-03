package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 15:45
 */
public class T59 {

    public int[][] generateMatrix(int n) {
        if (n == 0) return null;
        int[][] res = new int[n][n];
        int count = 1, j = 0;
        while (count <= n * n) {

            // 从左向右
            for (int i = j; i < n - j; i++)
                res[j][i] = count++;
            // 从上向下
            for (int i = j + 1; i < n - j; i++)
                res[i][n - j - 1] = count++;
            // 从右向左
            for (int i = n - j - 2; i >= j; i--)
                res[n - j - 1][i] = count++;
            // 从下向上
            for (int i = n - j - 2; i > j; i--)
                res[i][j] = count++;

            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        new T59().generateMatrix(4);
    }
}
