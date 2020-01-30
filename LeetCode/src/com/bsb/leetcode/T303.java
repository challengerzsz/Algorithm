package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 21:14
 */
public class T303 {

    public int[] array;

    public T303(int[] nums) {
        this.array = nums;
    }

    public int sumRange(int i, int j) {
        int count = 0;
        if (i < 0) i = 0;
        if (j >= array.length) j = array.length - 1;
        for (int k = i; k <= j; k++) {
            count += array[k];
        }
        return count;
    }
}
