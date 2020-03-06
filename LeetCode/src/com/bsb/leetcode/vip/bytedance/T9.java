package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-06 18:40
 */
public class T9 {

    // 回文数
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long temp = x;
        long reverse = 0;
        while (temp != 0) {
            reverse = reverse * 10 + (temp % 10);
            if (reverse > Integer.MAX_VALUE) return false;
            temp /= 10;
        }

        return reverse == x;
    }

    public static void main(String[] args) {
        new T9().isPalindrome(121);
    }
}
