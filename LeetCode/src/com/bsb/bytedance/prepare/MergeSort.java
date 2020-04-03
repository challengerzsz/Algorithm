package com.bsb.bytedance.prepare;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-03 16:35
 */
public class MergeSort {

    private void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (left + right) / 2;

        mergeSort(array, left, mid, temp);
        mergeSort(array, mid + 1, right, temp);
        merge(array, left, mid, right, temp);
    }

    private void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
            }
        }

        while (i <= mid) temp[index++] = array[i++];
        while (j <= right) temp[index++] = array[j++];

        index = 0;

        while (left <= right) {
            array[left++] = temp[index++];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 10, 1, 2, 3, 2, 11};
        new MergeSort().mergeSort(array, 0, array.length - 1, new int[array.length]);
        Arrays.stream(array).forEach(System.out::println);
    }
}
