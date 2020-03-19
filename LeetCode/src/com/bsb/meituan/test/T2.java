package com.bsb.meituan.test;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 16:37
 */
public class T2 {

    public static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            helper(input, i, i);
            helper(input, i, i + 1);
        }

        System.out.println(res);
    }

    private static void helper(String input, int i, int j) {
        while (i >= 0 && j <= input.length() - 1 && input.charAt(i) == input.charAt(j)) {
            i--;
            j++;
            res++;
        }
    }


}
