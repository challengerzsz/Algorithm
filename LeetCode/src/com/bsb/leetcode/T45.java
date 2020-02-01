package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-01 15:16
 */
public class T45 {

    public int jump(int[] nums) {
        // end表示能跳到的最远边界
        int end = 0;
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                // 更新边界
                end = max;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 1, 4};
        System.out.println(new T45().jump(array));
    }
}
