package com.bsb.leetcode.vip.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 10:37
 */
public class T1 {

    // 两树之和
    // O(n) + HashMap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                return new int[]{map.get(another), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
