package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 21:59
 */
public class T287 {

    // 原来这种算法叫 弗洛伊德的乌龟和兔子(循环检测)
    public int findDuplicate(int[] nums) {
        int p = nums[0];
        int q = nums[0];
        do {
            p = nums[p];
            q = nums[nums[q]];
        } while (p != q);

        int p1 = nums[0];
        int p2 = p;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }
}
