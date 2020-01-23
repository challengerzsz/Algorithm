package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-23 15:40
 */
public class T214 {

    public String shortestPalindrome(String s) {
        // 首先判断是不是已经存在部分回文
        // 如果不存在的话那就直接以第一个元素为中心向前添加后面的所有字符
        if (s == null || s.trim().length() == 0) return null;
        int mid = s.length() / 2 - 1;
        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        while (i < s.length() && s.charAt(i + 1) == s.charAt(i)) i++;

        int index = s.indexOf(s.charAt(i - 1), s.length() - i - 1);
        if (index != -1) {
            stringBuilder.append(s.substring(index + 1));
            stringBuilder.append(s);
            System.out.println(stringBuilder.toString());
            return stringBuilder.toString();
        }

        stringBuilder.append(s.substring(mid));
        stringBuilder.append(s);
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new T214().shortestPalindrome("aacecaaa");
    }
}
