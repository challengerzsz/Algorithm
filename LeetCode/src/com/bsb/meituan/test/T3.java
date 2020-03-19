package com.bsb.meituan.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 16:54
 */
public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = scanner.nextInt();
        scanner.close();
        if (n <= 1) System.out.println(0);
        int res = 0;

        int cost;
        for (int i = 0; i < coins.length - 1; i++) {
            Arrays.sort(coins);
            cost = coins[i] + coins[i + 1];
            res += cost;
            coins[0] = Integer.MAX_VALUE;
            coins[1] = cost;
        }

        System.out.println(res);
    }
}
