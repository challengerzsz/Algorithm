package com.bsb.leetcode.vip.bytedance;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 15:59
 */
public class T31 {

    // 下一个排列
    // 从后向前找 找到第一个逆序对[i - 1, i] 排序当前元素至末尾[i, end]
    // 挑选排序后第一个大于[i - 1]的元素进行交换 交换完成就是结果
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length - 1;
        for (; i >= 0; i--) {
            // 如果一趟都没找到这个逆序 证明已经是最大排列 没有下一个排列
            if (i == 0) {
                Arrays.sort(nums);
                return;
            }
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, nums.length);
                for (int j = i; j <= nums.length - 1; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        new T31().nextPermutation(new int[]{1, 3, 2});
    }
}
