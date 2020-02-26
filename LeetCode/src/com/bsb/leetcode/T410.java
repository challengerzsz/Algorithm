package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-26 19:52
 */
public class T410 {


    // 分割数组最大值
    // 将数组分为m份
    // 每份数组中的最大和 要求是划分出来所有结果中最小的
    // 求这个最小值
    private int res = Integer.MAX_VALUE;

    // 暴力dfs 枚举所有可能切割的位置
    public int splitArray(int[] nums, int M) {
        dfs(nums, 0, 0, 0, 0, M);
        return res;
    }

    // 在dfs中curMax其实是每次划分数组之后的最大值
    private void dfs(int[] nums, int index, int count, int curSum, int curMax, int M) {
        // 在满足切割成M个数组的时候更新全局最小值
        if (index == nums.length && count == M) {
            res = Math.min(res, curMax);
            return;
        }
        if (index == nums.length) {
            return;
        }
        if (index > 0) {
            dfs(nums, index + 1, count, curSum + nums[index],
                    Math.max(curMax, curSum + nums[index]), M);
        }
        if (count < M) {
            dfs(nums, index + 1, count + 1, nums[index], Math.max(curMax, nums[index]), M);
        }
    }
}
