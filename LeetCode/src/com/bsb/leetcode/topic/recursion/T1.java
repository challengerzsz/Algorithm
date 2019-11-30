package com.bsb.leetcode.topic.recursion;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-11 21:20
 */
public class T1 {

    public void reverseString(char[] s) {
        helper(s, 0);
    }

    private void helper(char[] s, int pos) {
        if (pos == s.length) return;

        helper(s, pos + 1);
        System.out.println(s[pos]);
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd'};
//        new T1().reverseString(s);
        System.out.println(s);
    }
}
