package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 09:38
 */
public class T228 {

    // 双指针找区间
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i, j = 0; j < nums.length; ++j) {
            i = j;
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) ++j;
            if (i == j) res.add(nums[i] + "");
            else res.add(nums[i] + "->" + nums[j]);
        }
        return res;
    }
}
