package com.bsb.leetcode;

import java.util.HashMap;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 21:23
 */
public class T205 {

    public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "ab";
        String b = "aa";
        System.out.println(new T205().isIsomorphic(a, b));
    }
}
