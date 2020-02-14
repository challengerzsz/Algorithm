package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 16:23
 */
public class T164 {

    // 要求线性复杂度解决
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > res) res = nums[i] - nums[i - 1];
        }
        return res;
    }

    // 基数排序 时间复杂度O(kn) k是最大数字的位数
    // 先对数组中的数字按照个位数字放置在对应的List中
    // 按照十位将刚才第一轮排好个位顺序的数字按顺序提取出来添加到新一轮的List中 以此类推
    public int maximumGap2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        int n = nums.length;
        int max = nums[0];
        // 找出最大的数字
        for (int i = 1; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int time = 1;
        // 直到将最大的元素归位
        while (max > 0) {
            // 将之前的元素清空
            for (int i = 0; i < 10; i++) {
                lists.set(i, new ArrayList<>());
            }
            // 将数字放入对应的位置
            for (int num : nums) {
                lists.get(num / time % 10).add(num);
            }

            // 将数字依次拿出来
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    nums[index] = lists.get(i).get(j);
                    index++;
                }

            }
            max /= 10;
            time *= 10;
        }

        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > res) {
                res = nums[i + 1] - nums[i];
            }
        }
        return res;
    }

    // 还有种思路是桶排 其实是差不多的思路 都是从选择排序方式的方式降低时间复杂度
}
