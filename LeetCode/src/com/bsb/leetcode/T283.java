package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 19:53
 */
public class T283 {

    // 移动0
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int temp : nums) {
            if (temp != 0) list.add(temp);
        }
        int count = nums.length - list.size();
        while (count != 0) {
            list.add(0);
            count--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }

    public void moveZeroes2(int[] nums) {
        for (int last = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[last];
                nums[last++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
