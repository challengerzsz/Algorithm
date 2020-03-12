package com.bsb.leetcode;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-12 22:53
 */
public class T1071 {

    public String gcdOfStrings(String str1, String str2) {
        // 最大公约数可行性
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法
        return str1.substring(0, helper(str1.length(), str2.length()));
    }

    private int helper(int a, int b) {
        return b == 0 ? a : helper(b, a % b);
    }

    public static void main(String[] args) {
//        System.out.println("abc".indexOf("a", 1));
        new T1071().gcdOfStrings("ABABAB", "ABAB");
    }

}
