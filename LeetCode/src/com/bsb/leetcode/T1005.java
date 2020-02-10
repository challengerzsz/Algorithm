package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 19:47
 */
public class T1005 {

    // K 次取反后最大化的数组和
    // 首先排序数组 按照升序排序
    // 这题的思路就是对一共K次的取反机会 应该优先找数组中是否有负数 并且按照遍历顺序取反即可 这个时候会把最小的负数转变为正数
    // 如果在取反负数之后还剩余K - n次取反机会 如果有0的话直接全部k次都给0取反
    // 如果数组中上面的情况之后还剩余K - n次机会 那就应该找最小的数字进行取反
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        int lastUnderZeroIndex = 0;
        if (A[0] < 0) {
            for (lastUnderZeroIndex = 0; lastUnderZeroIndex < A.length && K > 0; lastUnderZeroIndex++) {
                if (A[lastUnderZeroIndex] < 0) {
                    A[lastUnderZeroIndex] = -A[lastUnderZeroIndex];
                    K--;
                }
            }
        }
        if (lastUnderZeroIndex < A.length - 1 && K > 0) {
            if (A[lastUnderZeroIndex + 1] == 0) K = 0;
        }
        for (int i = 0; i < A.length; i++) {

            if (K > 0) {
                if (A[i] < 0) {
                    A[i] = -A[i];
                    K--;
                } else if (A[i] == 0) {
                    K = 0;
                } else {
                    A[i] = -A[i];
                    K--;
                }
            }
            sum += A[i];
        }
        return sum;
    }

    // 优化 这就只是代码量的优化了 每一趟都有一次nlogn的排序
    public int largestSumAfterKNegations2(int[] A, int K) {
        while (K > 0) {
            Arrays.sort(A);
            if (A[0] == 0) {
                K = 0;
            } else {
                A[0] = -A[0];
                K--;
            }
        }
        int sum = 0;
        for (int temp : A) {
            sum += temp;
        }
        return sum;
    }

}
