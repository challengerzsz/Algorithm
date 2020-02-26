package com.bsb.leetcode.tag.bytedane.array;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-26 16:39
 */
public class T10 {

    // 接雨水
    // 暴力解 对于每一个下标来说 该下标能接水的量取决于左右两边最高的柱子的最小值和当前高度的差值
    // 首次hard 暴力解未超时 10%
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            // 这里找左找右都需要从当前高度开始 因为可能当前高度就是最高的 到最后计算的时候可能会减出负值
            // 找右边最高的柱子
            for (int j = i; j < height.length; j++)
                rightMax = Math.max(rightMax, height[j]);
            // 找左边最高的柱子
            for (int j = i; j >= 0; j--)
                leftMax = Math.max(leftMax, height[j]);

            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;

    }

    // 暴力解优化
    // O(n) 99.98%
    public int trapBetter(int[] height) {
        if (height == null || height.length == 0) return 0;

        int res = 0;

        // 备忘录
        // 两个数组分别表示第i位左右的最大值
        int[] leftMax = new int[height.length], rightMax = new int[height.length];

        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        // 从左向右计算 leftMax
        for (int i = 1; i < height.length; i++)
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        // 从右向左计算 rightMax
        for (int i = height.length - 2; i >= 0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        // 从两个备忘录数组中取值做差计算结果
        for (int i = 1; i < height.length - 1; i++)
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        return res;
    }

    // 题解: 双指针
    // 避免提前计算备忘录 并且优化备忘录2个数组 边走边计算
    public int trap3(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int res = 0;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 如果leftMax > rightMax
            // 那么此时left指针所指位置能装下的水只和leftMax有关 因为根据上面那种算法min(leftMax, rightMax)计算结果一致
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                // 这里取决于右侧最高高度 因为此时左侧最高高度大于右侧最高高度
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

}
