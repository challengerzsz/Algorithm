package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 14:37
 */
public class T995 {

    // K连续位的最小翻转次数
    // 每次只能翻转K个大小的子序列 使其按位取反 最后保证A中全部都为1 如果不可能的话 返回-1
    // 其实就是贪心的思路
    // 遇到0开始的子序列 取反k个长度
    // 暴力解
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (i + K > A.length) return -1;
                res++;
                for (int j = i; j < i + K; j++)
                    A[j] ^= 1;
            }
        }
        return res;
    }

    // 贪心+事件
    // 设置event数组 event[i]表示以i为区间开始或结尾的时候翻转的次数
    // 以i为区间的开始进行的翻转视为开始事件 反之为结束事件
    public int minKBitFlips2(int[] A, int K) {

        int[] event = new int[A.length];
        int res = 0, flip = 0;

        // 当我们翻转子数组形如 A[i], A[i+1], ..., A[i+K-1]
        // 我们可以在此位置置反翻转状态，并且在位置 i+K 设置一个提醒，告诉我们在那里也要置反翻转状态
        for (int i = 0; i < A.length; ++i) {
            flip ^= event[i];
            // 我们是否必须翻转从此开始的子数组
            if (A[i] == flip) {
                // 翻转子数组 A[i] 至 A[i+K-1]
                res++;
                // 如果没办法翻转整个子数组了，那么就不可行
                if (i + K > A.length) return -1;
                flip ^= 1;
                if (i + K < A.length) event[i + K] ^= 1;
            }
        }

        return res;
    }
}
