package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 15:41
 */
public class T996 {

    // 正方形数组的个数
    // 数组A中如果有任意相邻的两对数字可以组成完全方数 则算是一种解
    // 考虑不同的排列
    private int res;

    private boolean[] visited;

    public int numSquarefulPerms(int[] A) {
        // 排序
        Arrays.sort(A);
        visited = new boolean[A.length + 1];

        dfs(A, -1, 0);
        return res;
    }

    private void dfs(int[] A, int pre, int index) {
        if (index >= A.length) {
            res++;
        }
        for (int i = 0; i < A.length; i++) {
            // 减枝 + 去重
            // 每一趟dfs都会去和所有的字符做拼接 看看能否满足完全平方数 并且之前有未使用到的元素
            if (visited[i] || (pre != -1 && !valid(pre + A[i]))
                    || (i != 0 && A[i] == A[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            dfs(A, A[i], index + 1);
            visited[i] = false;
        }
    }

    private boolean valid(int num) {
        double sqrt = Math.sqrt(num);
        return sqrt - (int) sqrt == 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 17, 8};
        new T996().numSquarefulPerms(A);
    }
}
