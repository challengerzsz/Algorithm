package com.bsb.tencent;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-20 20:39
 */
public class T3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            array2[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                ans ^= (array1[i] + array2[j]);
            }
        }

        System.out.println(ans);
    }
}
