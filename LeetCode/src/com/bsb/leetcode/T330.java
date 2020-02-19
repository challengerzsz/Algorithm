package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 15:36
 */
public class T330 {

    // 按要求补全数组
    // 一个已排序的正整数数组 nums，和一个正整数 n
    // 从 [1, n] 区间内选取任意个数字补充到 nums 中 使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示
    // 思路 对于nums中缺失的最小值t 假如nums中缺失 一定是需要填充一个小于t的数字和nums中的某几个数字求和组成t
    // 又因为需要最小次数的补充 所以这个补充的数字既要小于t 又需要是最大的 所以补充的这个值就需要为t
    public int minPatches(int[] nums, int n) {
        int res = 0, i = 0;
        // 这里一开始又溢出了
        long miss = 1;
        while (miss <= n) {
            // 计算缺失的每一趟最小的是多少 miss记录
            if (i < nums.length && nums[i] <= miss) miss += nums[i++];
            else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
