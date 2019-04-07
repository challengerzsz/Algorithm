package com.bsb.leetcode;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-08 00:30
 */
public class T7 {

    public int reverse(int x) {
        int abs = Math.abs(x);
        String s = "" + abs;
        try {
            StringBuilder sb = new StringBuilder(s);
            StringBuilder reverse = sb.reverse();
            int i = Integer.parseInt(reverse.toString());
            if (x < 0) {
                return -i;
            } else {
                return i;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        int a = 964631;
        System.out.println(new T7().reverse(a));
    }
}
