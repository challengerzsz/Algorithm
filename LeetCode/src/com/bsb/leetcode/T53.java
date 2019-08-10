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

    public static void main(String[] args) {
        int[] array = {-2, 3, -1, 1, -3};
        new T53().maxSubArray(array);
    }
}
