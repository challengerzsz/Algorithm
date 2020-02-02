package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-02 16:39
 */
public class T81 {

    // 上二分
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            // 去重
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 数组分为两组 因为数组为旋转排序数组
            if (nums[mid] >= nums[0] && (target > nums[mid] || target < nums[0])) {
                l = mid + 1;
            } else if (nums[mid] < nums[0] && target > nums[mid] && target < nums[0]) {
                // nums[mid] < nums[0] 表示nums[mid]位于右侧
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
