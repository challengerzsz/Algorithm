package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-15 20:34
 */
public class TestSpinSortArray {

    private int binary(int[] a) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid - 1] > a[mid]) {
                if (mid == a.length - 1) {
                    return mid;
                } else {
                    if (a[mid] < a[mid + 1]) return mid;
                }
            } else if (a[mid] < a[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new TestSpinSortArray().binary(new int[]{4, 5, 1}));
    }
}
