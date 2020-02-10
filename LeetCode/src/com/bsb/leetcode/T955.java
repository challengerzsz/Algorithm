package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 16:49
 */
public class T955 {

    // 删列造序 II
    // 跟I不同的是 II需要行列都保持字典序
    public int minDeletionSize(String[] A) {
        // 行
        int row = A.length;
        // 列
        int col = A[0].length();
        int res = 0;

        // 当前行
        String[] cur = new String[row];
        for (int j = 0; j < col; ++j) {

            String[] cur2 = Arrays.copyOf(cur, row);
            for (int i = 0; i < row; ++i)
                cur2[i] += A[i].charAt(j);

            if (helper(cur2))
                cur = cur2;
            else
                res++;
        }

        return res;
    }

    public boolean helper(String[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            // String 实现了Comparable接口
            if (A[i].compareTo(A[i + 1]) > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"ca", "bb", "ac"};
        new T955().minDeletionSize(strs);
    }

}
