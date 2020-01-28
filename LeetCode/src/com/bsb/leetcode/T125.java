package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 13:20
 */
public class T125 {

    public boolean isPalindrome(String s) {
        s = s.trim();
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if ((s.charAt(i) < 'a' || s.charAt(i) > 'z') || (s.charAt(i) < '0' || s.charAt(i) > '9')) {
                i++;
                continue;
            }
            if ((s.charAt(j) < 'a' || s.charAt(j) > 'z') || (s.charAt(j) < '0' || s.charAt(j) > '9')) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // "0P"没想到还有数字 醉了
    public boolean isPalindrome2(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new T125().isPalindrome("0P"));
    }
}
