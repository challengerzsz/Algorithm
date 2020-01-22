package com.bsb.leetcode;

import java.util.HashMap;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-22 10:01
 */
public class T217 {

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int temp : nums) {
            if (hashMap.containsKey(temp)) return true;
            hashMap.put(temp, temp);
        }
        return false;
    }
}
