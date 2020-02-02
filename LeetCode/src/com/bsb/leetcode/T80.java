package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-02 16:17
 */
public class T80 {

    public int removeDuplicates(int[] nums) {
        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    this.remove(nums, i);
                    i--;
                    length--;
                }
            } else {
                count = 1;
            }
            i++;
        }

        return length;
    }

    private int[] remove(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        return arr;
    }
}
