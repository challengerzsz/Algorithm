package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-04 14:00
 */
public class T55 {

    // 这题只需要判断是不是能跳过去
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        while (start <= end && end < nums.length - 1) {
            end = Math.max(end, nums[start] + start);
            start++;
        }
        return end >= nums.length - 1;
    }

    // leetcode题解 贪心
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 0, 5};
        new T55().canJump(array);
    }
}
