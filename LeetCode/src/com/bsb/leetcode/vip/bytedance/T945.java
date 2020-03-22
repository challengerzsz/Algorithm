package com.bsb.leetcode.vip.bytedance;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-22 20:34
 */
public class T945 {

    public int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                count += Math.abs(A[i - 1] - A[i]) + 1;
                A[i] += Math.abs(A[i - 1] - A[i]) + 1;
            }
        }
        return count;
    }
}
