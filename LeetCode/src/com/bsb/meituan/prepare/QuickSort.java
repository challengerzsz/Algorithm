package com.bsb.meituan.prepare;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 16:35
 */
public class QuickSort {

    public void quickSort(int[] a, int l, int r) {
        if (l > r) return;
        int i = l, j = r;
        while (i != j) {
            while (a[j] >= a[l] && i < j) j--;
            while (a[i] <= a[l] && i < j) i++;

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[l];
        a[l] = a[i];
        a[i] = temp;

        quickSort(a, l, i - 1);
        quickSort(a, i + 1, r);
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 1, 3, 7, 5};
        new QuickSort().quickSort(a, 0, 4);
        Arrays.stream(a).forEach(System.out::println);
    }
}

