package com.bsb.leetcode.vip.bytedance;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 10:34
 */
public class T128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int temp : nums) set.add(temp);
        int res = 0;
        for (int temp : nums) {

            if (!set.contains(temp - 1)) {
                int cur = temp;
                int count = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
