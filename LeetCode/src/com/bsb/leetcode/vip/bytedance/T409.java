package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 09:36
 */
public class T409 {

    // 构造最长回文串
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] lowerMap = new int[26];
        int[] upperMap = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upperMap[s.charAt(i) - 'A']++;
            } else {
                lowerMap[s.charAt(i) - 'a']++;
            }
        }

        int max = 0;
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            // upperMap
            if (upperMap[i] % 2 == 0) max += upperMap[i];
            else {
                if (!flag) {
                    max += upperMap[i];
                    flag = true;
                } else {
                    max += upperMap[i] - 1;
                }
            }

            // lowerMap
            if (lowerMap[i] % 2 == 0) max += lowerMap[i];
            else {
                if (!flag) {
                    max += lowerMap[i];
                    flag = true;
                } else {
                    max += lowerMap[i] - 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new T409().longestPalindrome("Aa");
    }
}
