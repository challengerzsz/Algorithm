package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 09:49
 */
public class T229 {

    // 题目要求时间复杂度O(n) 空间复杂度O(1)
    // 摩尔投票
    // (LC评论区)摩尔投票法。该算法用于1/2情况，它说：“在任何数组中，出现次数大于该数组长度一半的值只能有一个。”
    // 那么，改进一下用于1/3。可以着么说：“在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。”
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length < 1) return res;
        int count1 = 0, count2 = 0;
        int major1 = nums[0], major2 = nums[0];

        // 这里选出来的两个major数很巧妙
        for (int num : nums) {
            if (num == major1)
                count1++;
            else if (num == major2)
                count2++;
            else if (count1 == 0) {
                count1 = 1;
                major1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                major2 = num;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        // 加以验证 最多有2个数
        for (int num : nums) {
            if (num == major1)
                count1++;
            else if (num == major2)
                count2++;
        }
        if (count1 > nums.length / 3)
            res.add(major1);
        if (major1 != major2 && count2 > nums.length / 3)
            res.add(major2);
        return res;
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int min = nums.length / 3;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                count++;
                if (count == min) {
                    res.add(nums[i]);
                    while (i < nums.length && nums[i + 1] == nums[i]) ++i;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] array = {1, 1, 1, 3, 3, 2, 2, 2};
        
        new T229().majorityElement2(array); 
    }

}
