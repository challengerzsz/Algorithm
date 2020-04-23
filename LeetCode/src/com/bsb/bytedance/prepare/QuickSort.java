package com.bsb.bytedance.prepare;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-15 16:09
 */
public class QuickSort {

    static int count = 0;
    private void quickSort(int[] a, int start, int end) {
        if (start > end) return;

        count++;
        int left = start, right = end;

        while (left != right) {

            while (a[right] >= a[start] && left < right) right--;
            while (a[left] <= a[start] && left < right) left++;

            if (left < right) {
                swap(a, left, right);
            }
        }

        swap(a, start, left);

        quickSort(a, start, left - 1);
        quickSort(a, left + 1, end);
    }

    private void swap(int[] a, int left, int right) {

        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        new QuickSort().quickSort(a, 0, 4);
        Arrays.stream(a).forEach(System.out::println);
        System.out.println(count);
    }
}
