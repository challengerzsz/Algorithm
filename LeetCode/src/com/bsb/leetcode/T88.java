package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 21:11
 */
public class T88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 题目假设 nums1 有足够的空间
        int count = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[count] = nums2[j];
                j--;
                count--;
            } else {
                nums1[count] = nums1[i];
                i--;
                count--;
            }
        }
        for (int t = 0; t < j + 1; t++) {
            nums1[t] = nums2[t];
        }
    }

    // 这种写法真无敌
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
