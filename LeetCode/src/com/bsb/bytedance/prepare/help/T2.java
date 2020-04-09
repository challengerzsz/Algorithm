package com.bsb.bytedance.prepare.help;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-09 19:15
 */
public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] start = new int[n + 1];
        int[] end = new int[n + 1];

        int index = 1;
        for (int i = 0; i < n; i++) {
            start[scanner.nextInt()] = index;
            index++;
        }
        index = 1;
        for (int i = 0; i < n; i++) {
            end[scanner.nextInt()] = index;
            index++;
        }
        int res = 0;
        for (int i = 1; i < end.length; i++) {
            if (end[i] < start[i]) res++;
            else if (end[i] > start[i]) {
                for (int j = 1; j <= n; j++) {
                    if (j == i) continue;
                    if (start[j] < start[i] && end[j] > end[i]) res++;
                }
            }
        }

        System.out.println(res);
    }
}
