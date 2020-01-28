package com.bsb.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 16:27
 */
public class T137 {

    public int singleNumber(int[] nums) {
        // 借助map常规解
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }

        }
        return -1;
    }

    // 巧解
    // 每个数字出现了 3 次可以加起来乘以3
    // 然后减去之前所有的数字和这样得到的差就是只出现过一次的那个数字的2倍。
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            sum += nums[i];
        }
        int mul = 0;
        for (int n : set) {
            mul += n;
        }
        mul = mul * 3;
        return (mul - sum) / 2;
    }
}
