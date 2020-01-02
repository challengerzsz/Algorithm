package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 13:26
 */
public class T34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1 && nums[0] == target) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r && (l >= 0 && r <= nums.length)) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int k = mid, j = mid;
                // 二分 + 线性查找 难以满足log n要求 这里需要优化为二分查找target的左右区间
                // 其实就是优化二分的查询方式 遇到nums[mid] == target的时候不急着return 继续相左或向右找
                while (k >= 1) {
                    if (nums[k - 1] != target) break;
                    k--;
                }
                while (j < nums.length - 1) {
                    if (nums[j + 1] != target) break;
                    j++;
                }
                res[0] = k;
                res[1] = j;
                break;
            }
            if (target < nums[mid]) r = mid - 1;
            if (target > nums[mid]) l = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 4};
        int[] res = new T34().searchRange(array, 4);
        System.out.println(res[0] + " " + res[1]);
    }
}
