package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-08 16:32
 */
public class T376 {

    // 贪心系列
    // 摆动序列
    // 必要时可以通过删除来
    // 暴力解 寻找所有的摆动区间 统计最长长度
    // 超时 而且这题如果用暴力的话 其实是不符合贪心的思想的 因为没有在暴力的过程中做任何的删除或者取舍操作
    // 只是枚举了所有的字串 然后寻找最大的长度
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        // +1是为了包含nums[0]之后正确的长度
        return Math.max(helper(nums, 0, true), helper(nums, 0, false)) + 1;
    }

    /**
     * 递归方法
     *
     * @param nums
     * @param index 从哪里开始往后找摆动序列
     * @param flag  判断下一个数是大于或者小于nums[index] 本次向后寻找递增或者递减
     * @return
     */
    private int helper(int[] nums, int index, boolean flag) {
        int max = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if ((flag && nums[i] > nums[index]) || (!flag && nums[i] < nums[index]))
                // 如果这一步需要的是递增的元素 下一层递归就是从这开始向后找递减的元素(都是判断下一位是不是大于或小于本次index的元素)
                max = Math.max(max, 1 + helper(nums, i, !flag));
        }
        return max;
    }


    // 动态规划 做的题目还是太少了 贪心问题基本都可以使用dp解 只不过有可能dp的解法没有直观的贪心时间复杂度低
    // 这题的动态规划解参考了官解 状态定义和转移还是没有想出来
    // 本题的动态规划解思路是这样
    // 新建两个dp数组 一个是upDp 一个为downDp
    // 用upDp数组举例 upDp[i]为以i为序列末尾并且nums[i + 1] - nums[i] > 0 是上升摆动的
    // 如果我们发现某一个元素是上升摆动序列的末尾 应该考虑downDp[j] 并且 j < i
    // 如果存在downDp[j] + 1 > upDp[i]则说明j ～ i之间的元素被删除掉之后以i为结尾的区间是最长的摆动区间
    // 用这个思路去完成两个dp数组 并且随时做好max的统计
    public int wiggleMaxLengthByDp(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] upDp = new int[nums.length];
        int[] downDp = new int[nums.length];
        // 为了保证j < i
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    upDp[i] = Math.max(upDp[i], downDp[j] + 1);
                } else if (nums[i] < nums[j]) {
                    downDp[i] = Math.max(downDp[i], upDp[j] + 1);
                }
                // 这里因为两元素之间必须存在摆动 不能差值为0 所以没有else条件
            }
        }

        return Math.max(upDp[nums.length - 1], downDp[nums.length - 1]) + 1;
    }

}
