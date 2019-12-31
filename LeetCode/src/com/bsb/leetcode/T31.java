package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-31 11:05
 */
public class T31 {

    public void nextPermutation(int[] nums) {
        // 投机的方式试试.. 从后往前找找到有逆序对直接交换 但是不能保证是"下一个更大"的排列
        // 只能保证是比原排列更大的数 并不能保证是下一个
//        for (int i = nums.length - 1; i > 0; --i) {
//            if (nums[i - 1] < nums[i]) {
//                int t = nums[i];
//                nums[i] = nums[i - 1];
//                nums[i - 1] = t;
//                break;
//            }
//        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        int k = i + 1, j = nums.length - 1;
        while (k < j) {
            swap(nums, k, j);
            k++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        new T31().nextPermutation(a);
    }
}
