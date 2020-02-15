package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 15:36
 */
public class T238 {

    // 除自身以外 数组其他元素的乘积
    public int[] productExceptSelf(int[] nums) {
        // 超时
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int mul = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                mul *= nums[j];
            }
            res[i] = mul;
        }
        return res;
    }

    // 尝试缓存计算结果或者打表
    // 缓存的话 因为每一次i的变化 其实缓存的结果都不能被用上
    // 所以还是打表吧
    // left 和 right数组 当在i这个下标的时候 left[i]则表示原数组中i左侧的乘积 同理 right[i]就是右侧的乘积
    public int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        // 打表left和right数组
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    // 题目要求空间负责度O(1) 并且res数组不计算在内 那就利用res再来一次上面的思路 在打表的过程中直接填充进res
    public int[] productExceptSelf3(int[] nums) {

        int[] res = new int[nums.length];

        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int fromRightNum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * fromRightNum;
            fromRightNum *= nums[i];
        }

        return res;
    }
}
