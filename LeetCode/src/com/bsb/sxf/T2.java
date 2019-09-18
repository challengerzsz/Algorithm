package com.bsb.sxf;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-18 17:02
 */
public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] strArray = str.split(",");
        for (int i = 0; i < strArray.length - 1; i++) {
            for (int j = 0; j < strArray.length - i - 1; j++) {
                if (ifBig(strArray[j], strArray[j + 1])) {
                    String temp = strArray[j];
                    strArray[j] = strArray[j + 1];
                    strArray[j + 1] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String strT : strArray) {
            stringBuilder.append(strT).append(",");
        }
        System.out.print(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
    }

    private static boolean ifBig(String s, String s1) {
        String[] time1 = s.split("\\.");
        String[] time2 = s1.split("\\.");
        if (Integer.valueOf(time1[0]) > Integer.valueOf(time2[0])) {
            return true;
        }
        if (Integer.valueOf(time1[1]) > Integer.valueOf(time2[1])) {
            return true;
        }
        if (Integer.valueOf(time1[2]) > Integer.valueOf(time2[2])) {
            return true;
        }

        return false;
    }
}
