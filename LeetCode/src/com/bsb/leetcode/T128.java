package com.bsb.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-04 18:37
 */
public class T128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 排序计算连续字串最大长度
        Arrays.sort(nums);

        int max = 1;
        int now = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    now += 1;
                } else {
                    max = Math.max(max, now);
                    now = 1;
                }
            }
        }

        return Math.max(max, now);
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // set降低一下时间复杂度
        int max = 0;
        for (int num : set) {
            // 总体思路其实是一样的
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentCount += 1;
                }

                max = Math.max(max, currentCount);
            }
        }

        return max;
    }
}
