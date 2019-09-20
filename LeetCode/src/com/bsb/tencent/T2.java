package com.bsb.tencent;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-20 20:57
 */
public class T2 {

    private static Integer pre = null;
    private static Integer MIN = Integer.MAX_VALUE;
    private static Integer now = 0;
    private static int[] array1;
    private static int[] array2;
    private static int[] array3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        array1 = new int[n];
        array2 = new int[n];
        array3 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
            array2[i] = scanner.nextInt();
            array3[i] = scanner.nextInt();
        }
        back(0, n);
        System.out.println(MIN);
    }

    private static void back(int i, int n) {
        if (i == n) {
            MIN = Math.min(MIN, now);
            return;
        }
        Integer temp = pre;
        for (int p = 0; p < 3; p++) {
            if (pre != null && p == pre) {
                continue;
            } else {
                if (p == 0) {
                    now += array1[i];
                    pre = 0;
                    back(i + 1, n);
                    now -= array1[i];
                } else if (p == 1) {
                    now += array2[i];
                    pre = 1;
                    back(i + 1, n);
                    now -= array2[i];
                } else {
                    now += array3[i];
                    pre = 2;
                    back(i + 1, n);
                    now -= array3[i];
                }
            }
            pre = temp;
        }
    }
}
