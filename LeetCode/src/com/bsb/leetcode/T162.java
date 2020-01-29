package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 15:52
 */
public class T162 {


    // 还是直接二分 找peak
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1]) return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1};
        System.out.println(new T162().findPeakElement(array));
    }

}
