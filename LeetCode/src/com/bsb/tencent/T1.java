package com.bsb.tencent;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-20 20:07
 */
public class T1 {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        boolean flag = false;
//        for (int j = 1; j <= t; j++) {
//            int n = scanner.nextInt();
//            scanner.nextLine();
//            String str = scanner.nextLine();
//            if (n >= 11 && str.charAt(0) == '8') {
//                System.out.println("YES");
//                continue;
//            }
//            if (n < 11) {
//                System.out.println("NO");
//                continue;
//            }
//            if (n > 11 && str.charAt(0) != '8') {
//                int index = str.indexOf('8');
//                if (index == -1) {
//                    System.out.println("NO");
//                    continue;
//                }
//                int left = str.length() - index;
//                if (left >= 11) {
//                    flag = true;
//                }
//            }
//            if (flag) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
//    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        boolean flag = false;
//        while (t != 0) {
//            int n = scanner.nextInt();
//            scanner.nextLine();
//            String str = scanner.nextLine();
//
//            int index;
//            for (int i = 0; i < str.length(); i++) {
//                if (str.charAt(i) == '8') {
//                    index = i;
//                    int left = str.length() - index;
//                    if (left >= 11) {
//                        flag = true;
//                        break;
//                    }
//                }
//            }
//            if (flag) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//            t--;
//        }
//    }

    public static void main(String[] args) {
        String a = "我";
        String b = "1";
        System.out.println(a + b);
    }
}
