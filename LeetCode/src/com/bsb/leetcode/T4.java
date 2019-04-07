package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-07 22:43
 */
public class T4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sum = nums1.length + nums2.length;
        double result = 0;
        int[] results = new int[sum];
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                results[index] = nums1[i];
                index++;
                i++;
            } else if (nums1[i] > nums2[j]) {
                results[index] = nums2[j];
                index++;
                j++;
            } else {
                results[index] = nums1[i];
                index++;
                i++;
            }
        }

        if (i < nums1.length) {
            while (i < nums1.length) {
                results[index] = nums1[i];
                i++;
                index++;
            }
        }

        if (j < nums2.length) {
            while (j < nums2.length) {
                results[index] = nums2[j];
                j++;
                index++;
            }
        }

        if (sum % 2 == 0) {
            if (results.length == 2) {
                return ((double) results[0] + (double)results[1]) / 2;


            }
            double low = results[(sum / 2) - 1];
            double high = results[sum / 2];
            result = (low + high) / 2;
        } else {

            result = results[sum / 2];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {2, 3};
        System.out.println(new T4().findMedianSortedArrays(a, b));
    }
}
