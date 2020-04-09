package com.bsb.bytedance.prepare.help;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-09 19:32
 */
public class T4 {

    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        if (k <= 1) {
            System.out.println(0);
            return;
        }

        if (k == 2) {
            System.out.println(3);
            return;
        }

        dfs(0, k);
        System.out.println(res);
    }

    private static void dfs(int index, int k) {

        if (k == 1 && index != 0) {
            res = (int) (res % (10e9 + 7)) + 1;
            return;
        }

        if (k == 1) return;

        for (int i = 0; i < 4; i++) {
            if (i == index) continue;
            dfs(i, k - 1);
        }
    }
}
