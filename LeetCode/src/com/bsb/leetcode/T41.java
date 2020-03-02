package com.bsb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 19:43
 */
public class T41 {

    // 这题有点难 要求O(n)解
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= len; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }

    // 题解好思路 桶 + 抽屉原理
    // 这题其实是利用自身数组nums数组做hash表
    // 跟tx的第一个面试题一样
    // 那个题是这样的 如果数组中有n个数字 数字的大小0 ～ n - 1 找出重复的数字
    // 这个题的思路同样如此
    // 因为题目要求找出缺失的第一个正整数
    // 所以我们可以得到这种映射
    // num - index
    // 1   -   0
    // 2   -   1
    // …   -   …
    // 最终统计以nums数组为hash表的每位元素是否都有特定的值还原上去
    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }
        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
