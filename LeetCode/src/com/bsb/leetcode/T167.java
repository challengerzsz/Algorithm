package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 17:24
 */
public class T167 {

    // 简单题 两数之和 保证i < j
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return new int[0];
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) --r;
            else if (sum < target) ++l;
            // 这题有点弱智的是index要 + 1
            else return new int[]{l + 1, r + 1};
        }
        return new int[0];
    }
}
