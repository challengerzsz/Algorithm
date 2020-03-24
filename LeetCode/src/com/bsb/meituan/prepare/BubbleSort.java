package com.bsb.meituan.prepare;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-23 18:55
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 2, 1, 100, 3, 7, 11};

        for (int i = 0; i < a.length; i++) {
            boolean flag = false;

            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }

            if (!flag) break;
        }

        Arrays.stream(a).forEach(System.out::println);
    }

}
