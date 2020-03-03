package com.bsb.leetcode.interview;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-03 19:46
 */
public class T1001 {

    // 合并两个排序数组
    // A中已经预留了位置
    public void merge(int[] A, int m, int[] B, int n) {
        int index = 0;
        for (int i = m; i < m + n && index < n; i++, index++) {
            A[i] = B[index];
        }
        Arrays.sort(A);
    }

    public void merge2(int[] A, int m, int[] B, int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
        while (j >= 0) A[k--] = B[j--];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        new T1001().merge2(A, 3, B, 3);
    }
}
