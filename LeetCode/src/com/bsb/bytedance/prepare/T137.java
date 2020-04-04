package com.bsb.bytedance.prepare;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-04 21:33
 */
public class T137 {

    // (a + b + c) * 3 - (a + a + a + b + b + b + c) = 2 * c
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            sum += nums[i];
        }
        long mul = 0;
        for (int n : set) {
            mul += n;
        }
        mul = mul * 3;
        return (int) ((mul - sum) / 2);
    }
}
