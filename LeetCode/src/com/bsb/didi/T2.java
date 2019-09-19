package com.bsb.didi;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-19 19:32
 */
public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }


        int[] sum = new int[n];
        int[] start = new int[n];
        int min = 0;
        for (int i = 0; i < m; i++) {
            min += array[i];
            sum[i] = Integer.MAX_VALUE;

        }
        sum[m - 1] = min;
        start[m - 1] = 0;
        for (int i = m; i < n; i ++) {
            int s = 0;
            for (int j = start[i - 1]; j < i - m + 1; j++) {
                s += array[j];
            }
            if (s > 0) {
                start[i] = i - m + 1;
                sum[i] = sum[i - 1] + array[i] - s;
            } else {
                start[i] = start[i - 1];
                sum[i] = sum[i - 1] + array[i];
            }

            if (sum[i] < min) {
                min = sum[i];
            }
        }

        System.out.println(min);
    }
}
