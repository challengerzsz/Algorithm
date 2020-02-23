package com.bsb.leetcode.contest.eighteenth;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-23 10:35
 */
public class T5170 {

    // 验证二叉树
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) in[leftChild[i]]++;
            if (rightChild[i] != -1) in[rightChild[i]]++;
        }

        int count0 = 0;
        int countOther = 0;
        for (int temp : in) {
            if (temp == 0) count0++;
            if (temp > 1) countOther++;
        }
        return count0 == 1 && countOther == 0;
    }

    public boolean validateBinaryTreeNodes2(int n, int[] leftChild, int[] rightChild) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (leftChild[i] == -1) count++;
            if (rightChild[i] == -1) count++;
        }
        return count == n + 1;
    }
}
