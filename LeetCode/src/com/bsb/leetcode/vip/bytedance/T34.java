package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-01 17:11
 */
public class T34 {


    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i > 0 && nums[i - 1] == target) i--;
                while (j < nums.length - 1 && nums[j + 1] == target) j++;
                res[0] = i;
                res[1] = j;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T34().searchRange(new int[]{1, 2, 2, 2, 3, 4, 5}, 2);
    }
}
