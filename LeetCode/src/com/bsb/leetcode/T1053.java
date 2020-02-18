package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 21:01
 */
public class T1053 {

    // 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列
    // 一开始的思路是直接暴力解 这题感觉没有什么可贪心的地方 如果遇到一个数字的话 查找之后最大的且小于它的值 直接交换
    // 但是这种做法没有考虑到字典序的问题 题目描述得到的新数组必须是小于原数组的最大字典序
    // 逆向考虑 因为交换低位的数字能保证能获取到字典序小于原数组 并且数字能是小于原数组的最大字典序
    public int[] prevPermOpt1(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) continue;
            else {
                int max = 0;
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] < A[i] && A[j] > max) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        return A;
                    }
                }
            }
        }

        return A;
    }

    // 逆向考虑的思路
    public int[] prevPermOpt1ByFromBack(int[] A) {

        for (int i = A.length - 2; i >= 0; i--) {
            int max = i + 1;

            for (int j = i + 1; j < A.length; j++) {
                // 找比当前元素小的最大值
                if (A[j] > A[max] && A[j] < A[i]) {
                    max = j;
                }
            }

            if (A[i] > A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
                return A;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        new T1053().prevPermOpt1ByFromBack(A);
    }
}
