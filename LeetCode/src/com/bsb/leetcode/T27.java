package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-31 10:13
 */
public class T27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        if (nums.length == 0 || (nums.length == 1 && nums[0] != val)) return 0;

        int i = 0, j = 0;
        while (j < nums.length) {
            // 遇到不和val相同的值就交换
            // i维护的是不包含val的序列的末尾下标
            if (nums[j] == val) {
                j++;
            } else {
                nums[i++] = nums[j++];
            }
        }
        return nums.length - (j - i);
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 2, 3};
        System.out.println(new T27().removeElement(array, 3));
    }
}
