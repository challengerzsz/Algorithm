package com.bsb.leetcode;

/**
 * @author : zengshuaizh
 * @date : 2020-01-29 15:31
 */
public class T154 {

    // 旋转数组找最小II 直接二分找

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > nums[h])
                l = mid + 1;
            else if (nums[mid] < nums[h])
                h = mid;
            else
                h--;
        }
        return nums[l];
    }
}
