package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 15:28
 */
public class T910 {

    // 最小差值II
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n - 1] - A[0];
        for (int i = 1; i < n; i++) {
            int min = Math.min(A[0] + K, A[i] - K);
            int max = Math.max(A[n - 1] - K, A[i - 1] + K);
            res = Math.min(max - min, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 6};
        new T910().smallestRangeII(array, 3);
    }
}
