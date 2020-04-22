package com.bsb.bytedance.prepare.sort;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 16:19
 */
public class QuickSort {

    public void quickSort(int[] a, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        int i = left;
        int j = right;
        while (i < j) {
            while (a[j] >= a[left] && i < j) j--;
            while (a[i] <= a[left] && i < j) i++;

            if (i != j) {
                swap(a, i, j);
            }
        }

        swap(a, left, i);
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};

        new QuickSort().quickSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(System.out::println);
    }
}
