package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-01 17:18
 */
public class T33 {

    // 时间复杂度要求O(log n)
    // 这个题目其实思路比较清晰 简单来说就是通过找到旋转终点或者是两段起点不一致的上升区间
    // 再去相对应的区间中去找目的target
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }


    // 讨论区极简做法
    public int searchByEasyWay(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid] ^ (target > nums[mid]))) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l == r && nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3};
        new T33().search(array, 0);
    }
}
