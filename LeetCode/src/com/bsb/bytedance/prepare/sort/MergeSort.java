package com.bsb.bytedance.prepare.sort;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-22 16:27
 */
public class MergeSort {

    public void mergeSort(int[] a, int i, int j, int[] temp) {

        if (i >= j) return;

        int mid = (i + j) / 2;
        mergeSort(a, i, mid, temp);
        mergeSort(a, mid + 1, j, temp);

        merge(a, i, mid, j, temp);
    }

    private void merge(int[] a, int i, int mid, int j, int[] temp) {
        int left = i;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= j) {
            if (a[left] < a[right]) {
                temp[index++] = a[left++];
            } else {
                temp[index++] = a[right++];
            }
        }

        while (left <= mid) temp[index++] = a[left++];
        while (right <= j) temp[index++] = a[right++];

        index = 0;
        while (i <= j) {
            a[i++] = temp[index++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        new MergeSort().mergeSort(a, 0, a.length - 1, new int[5]);

        Arrays.stream(a).forEach(System.out::println);
    }
}
