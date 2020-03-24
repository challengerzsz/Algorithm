package com.bsb.meituan.prepare;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 19:13
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {10, 2, 3, 11, 1, 5, 7, 9, 20};

        for (int i = 1; i < a.length; i++) {
            int newVal = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > newVal) {
                    a[j + 1] = a[j];
                } else break;
            }

            a[j + 1] = newVal;
        }

        Arrays.stream(a).forEach(System.out::println);
    }
}
