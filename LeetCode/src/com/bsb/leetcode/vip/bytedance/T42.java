package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 16:35
 */
public class T42 {

    // 接雨水
    public int trap(int[] height) {
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            int left = i - 1, right = i + 1;
            int leftMax = height[i], rightMax = height[i];
            while (left >= 0 || right < height.length) {
                if (left >= 0) {
                    if (height[left] > leftMax) leftMax = height[left];
                    left--;
                }
                if (right < height.length) {
                    if (height[right] > rightMax) rightMax = height[right];
                    right++;
                }
            }
            if (leftMax < height[i] || rightMax < height[i]) continue;

            res += Math.min(leftMax, rightMax) - height[i];
        }

        return res;
    }

    // 优化
    public int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int res = 0;
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    // 对每个位置来说都是取决于左右两边最大的元素
    // 但是用数组维护的话空间复杂度太高了
    public int trap3(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
