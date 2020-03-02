package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-02 11:23
 */
public class T75 {

    // 荷兰三色旗问题解
    // 这题目解释的太好了我就直接班上来了...
    // 最后需要排列成值为0 1 2的数组 每个元素的个数不限 只需要按顺序排列即可
    public void sortColors(int[] nums) {
        // p0维护的是数组中左边0的最右边界
        // p2维护的是数组最右边2的最左边界
        // cur是介于p0和p2之间的待处理元素下标
        int p0 = 0, curr = 0;

        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++; // 遇到1则不变 因为1的颜色就是在数组中间
        }
    }
}
