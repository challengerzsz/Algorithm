package com.bsb.leetcode.tag.bytedane.array;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 20:42
 */
public class T3 {

    // 搜索旋转排序数组
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            // 右侧区间单调
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else { // mid ～ right不单调
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
