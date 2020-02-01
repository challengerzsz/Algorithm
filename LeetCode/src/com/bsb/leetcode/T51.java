package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-01 15:31
 */
public class T51 {

    // N皇后
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] array = new int[n];
        // 从第0个放
        helper(0, array, n);
        return res;
    }

    private void helper(int n, int[] array, int max) {
        if (n == max) {
            // 放完了，且前面全都可以无冲突放置 添加结果集
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < max; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < max; j++) {
                    if (array[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tempList.add(sb.toString());
            }
            res.add(tempList);
            return;
        }
        // 继续摆放
        for (int i = 0; i < max; i++) {
            // 放第n个皇后，依次放在第i列上，行不会冲突
            array[n] = i;
            if (!check(array, max, n)) {
                // 继续摆
                helper(n + 1, array, max);
            }
        }
    }

    private boolean check(int[] array, int max, int n) {
        // 检查当前放置的皇后能否正确存在
        for (int i = 0; i < n; i++) {
            if (Math.abs(n - i) == Math.abs(array[n] - array[i]) || (array[n] == array[i])) {
                return true;
            }
        }
        return false;
    }
}
