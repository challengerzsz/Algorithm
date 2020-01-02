package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 14:11
 */
public class T35 {

    public int searchInsert(int[] nums, int target) {

        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) {
                ans = i;
                flag = true;
                break;
            }
        }
        if (ans == 0 && !flag) ans = nums.length;
        return ans;
    }

    // 二分 优化时间复杂度
    public int searchInsertByBS(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
