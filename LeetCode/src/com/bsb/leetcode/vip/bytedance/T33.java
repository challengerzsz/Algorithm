package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 11:25
 */
public class T33 {

    // 搜索旋转排序数组
    // 其实就是在不断的二分过程中既判断了旋转节点的位置 又能正常二分搜target
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;
            // nums[mid] < nums[right] 证明[mid, right]升序 区间内无翻转
            else if (nums[mid] < nums[right]) {
                // 如果target在[nums[mid], nums[right]]内 向右二分
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                // 只能向左搜
                else
                    right = mid - 1;
            } else {
                // 这里其实就是说[mid, right]中包含一个旋转节点 并不是单调递增的
                // 如果target在[left, mid]向左搜
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    // 向右搜
                    left = mid + 1;
            }
        }
        return -1;
    }
}
