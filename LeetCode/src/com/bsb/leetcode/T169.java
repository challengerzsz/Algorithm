package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-29 16:10
 */
public class T169 {

    // 寻找数组中超过n/2次的数
    // 继续摩尔投票
    // 遇到相同的数 count++ 不同的数count-- 如果count == 0 就更换投票的对象 也就是说换一个元素
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else {
                if (res == nums[i]) count++;
                else count--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 5};
        System.out.println(new T169().majorityElement(array));
    }
}
