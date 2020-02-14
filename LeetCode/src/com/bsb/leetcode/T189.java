package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 21:02
 */
public class T189 {

    // 数组元素右移k次
    // 暴力直接移动k次
    public void rotate(int[] nums, int k) {
        int temp, p;
        for (int i = 0; i < k; i++) {
            p = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = p;
                p = temp;
            }
        }
    }

    // 通过计算直接找到分界位置 把数组元素直接塞进应该在的地方
    // 这里需要注意如果k的大小大于nums.length的话 就需要取余了
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        // 直接把temp数组复制给nums
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
    }
}
