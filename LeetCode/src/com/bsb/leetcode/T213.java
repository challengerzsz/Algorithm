package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-11 20:19
 */
public class T213 {

    // 打家劫舍II
    // 这个小偷变得专业了 但是给他能够盗窃的房子围成了一个圈 还是那个规则 如果连续偷2家就会报警
    // 其实成环之后需要考虑的就是首位两个房子偷不偷的问题
    // 1、 两个都不偷 那能偷的就是n - 2
    // 2、 偷头不偷尾 || 偷尾不偷头 n - 1
    // 其实只需要判断第二种情况的两种情况哪种能够获得的收益最大就好了
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // 取偷第一户或者不偷的最大值
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    private int helper(int[] nums, int start, int end) {
        // dpi只需要基于两个状态 其实打家劫舍I也一样 优化一下空间复杂度
        int temp1 = 0, temp2 = 0;
        int dpi = 0;
        for (int i = end; i >= start; i--) {
            dpi = Math.max(temp1, nums[i] + temp2);
            temp2 = temp1;
            temp1 = dpi;
        }
        return dpi;
    }
}
