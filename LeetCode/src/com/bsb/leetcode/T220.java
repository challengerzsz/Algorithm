package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 10:53
 */
public class T220 {

    // nums中包含abs(nums[i] - nums[j]) == t && abs(i - j) == k
    // 这题真没什么意思 而且题目描述不清楚 用例还是一堆子垃圾数据
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 1};
        System.out.println(new T220().containsNearbyAlmostDuplicate(array, 1, 2));
    }
}
