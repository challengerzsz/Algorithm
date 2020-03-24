package com.bsb.meituan.spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 18:46
 */
public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long m = scanner.nextLong();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        long[] need = new long[k];

        int ans = 0;
        int hneed = 0;
        for (int i = 0; i < k; i++) {
            need[i] = scanner.nextInt();
            hneed += need[i];
        }

        Arrays.sort(need);

        int index = 0;
        while (n > 0 && k > 0 && m >= need[index]) {
            // n轮任务
            long sneed = n * need[index] <= m ? need[index] :
                    (m / need[index]) * need[index];
            double svalue = (sneed / need[index]) * p;
            double hvalue = m >= hneed ? k * p + q : 0;
            if (hvalue > svalue && m - hneed < need[index]) {
                ans += hvalue;
                m -= hneed;
                n--;
            } else if ((n * need[index] > m && svalue > hvalue) || svalue / sneed >= hvalue / hneed) {
                ans += svalue;
                hneed -= need[index];
                m -= sneed;
                k--;
                index++;
            } else {
                ans += hvalue;
                m -= hneed;
                n--;
            }
        }
        System.out.println(ans);
    }
}
