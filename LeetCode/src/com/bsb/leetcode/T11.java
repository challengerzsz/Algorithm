package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-07-06 17:23
 */
public class T11 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] array = {1,8,6,2,5,4,8,3,7};
//        System.out.println(new T11().maxArea(array));

        System.out.println(1 + 'a');
    }
}
