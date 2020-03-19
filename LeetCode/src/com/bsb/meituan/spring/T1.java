package com.bsb.meituan.spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 18:46
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();
        for (int i = 0; i < n; i++) b[i] = scanner.nextLong();
        scanner.close();
        Arrays.sort(a);
        Arrays.sort(b);
        long maxA = a[n - 1] + a[n - 2] + a[n - 3];
        long maxB = b[n - 1] + b[n - 2] + b[n - 3];

        System.out.println(Math.max(maxA, maxB));
    }
}
