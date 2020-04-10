package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 20:48
 */
public class T151 {

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) return "";
        int i = 0, j = s.length() - 1;
        while (i < s.length() - 1) {
            if (s.charAt(i) == ' ') i++;
            if (s.charAt(i) != ' ') break;
        }
        while (j > i) {
            if (s.charAt(j) == ' ') j--;
            if (s.charAt(j) != ' ') break;
        }
        String newStr = s.substring(i, j + 1);
        String[] array = newStr.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int k = array.length - 1; k >= 0; k--) {
            if (array[k].equals("")) continue;
            sb.append(array[k]).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String strs = "a good   example";
        System.out.println(new T151().reverseWords(strs));
    }
}
