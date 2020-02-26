package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 16:54
 */
public class T300 {

    // 最长上升序列
    // 这种题一看就是动态规划能够解决的问题
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;

        // dp数组表示到每一位能够组成的最长上升序列长度
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 题目要求nlogn 所以二分再来一个
    // 这题目的思路是这样 tag数组标记目前为止遍历nums数组得出的最小值
    // 如果当前遍历的nums数组元素<tag数组的最后一个元素 那么就替换 否则将这个值添加进tag数组 res++
    // 表示这个值可以被作为当前最大的递增序列中的一员
    // 找到添加的位置使用的是二分 所以时间复杂度nlogn
    public int lengthOfLIS2(int[] nums) {
        int[] tag = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tag[m] < num) i = m + 1;
                else j = m;
            }
            tag[i] = num;
            if (res == j) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        new T300().lengthOfLIS2(array);
    }
}
