package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-22 9:39
 */
public class T724 {

    // 寻找数组的中心索引
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
