package com.bsb.leetcode.interview.simulate.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-03 21:23
 */
public class T3 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3};
        System.out.println(new T3().minSubArrayLen(7, array));
    }
}
