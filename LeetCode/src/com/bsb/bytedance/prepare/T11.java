package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-18 16:45
 */
public class T11 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            // 保持较大的一个高度 期待另一边出现更大或相等的高度
            if (height[left] > height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
