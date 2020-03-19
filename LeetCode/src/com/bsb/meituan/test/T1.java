package com.bsb.meituan.test;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 16:24
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"").append((Integer.valueOf(a.substring(1, a.length() - 1)) +
                Integer.valueOf(b.substring(1, b.length() - 1)))).append("\"");
        System.out.println(stringBuilder.toString());
    }
}
