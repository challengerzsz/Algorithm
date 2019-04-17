package com.bsb.leetcode;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-17 21:25
 */
public class T8 {

    public int myAtoi(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Integer result = 0;
        if (str.length() == 0 || str == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i ++) {
            if ((str.charAt(0) == '-' && i == 0)) {
                count++;
                stringBuilder.append('-');
                continue;
            }
            if ((str.charAt(0) == '+' && i == 0)) {
                count++;
                stringBuilder.append('+');
                continue;
            }
            if (str.charAt(i) == ' ') {
                continue;
            }
            if ((str.charAt(i) == '-' || str.charAt(i) == '+')) {
                stringBuilder.append(str.charAt(i));
                count++;
                continue;
            } else if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                stringBuilder.append(str.charAt(i));
                continue;
            } else {
                break;
            }
        }
        if (count > 1) {
            return 0;
        }
        if (stringBuilder.indexOf("0") != -1 && stringBuilder.indexOf("+") != -1) {
            return 0;
        }
        if (stringBuilder.length() == 1 && (stringBuilder.charAt(0) == '+' || stringBuilder.charAt(0) == '-')) {
            return 0;
        }
        if (stringBuilder.length() == 0) {
            return 0;
        }
        try {
            result = Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new T8().myAtoi("-91283472332"));
    }
}
