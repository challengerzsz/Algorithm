package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-07-07 13:04
 */
public class T53 {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maxSubArrayByGreed(int[] nums) {
        int maxRes = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 步步最优 在这里就是保证步步最大
            max = Math.max(nums[i], max + nums[i]);
            maxRes = Math.max(maxRes, max);
        }
        return maxRes;
    }

    public int maxSubArrayByDP(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {-2, 3, -1, 1, -3};
        new T53().maxSubArray(array);
    }
}
