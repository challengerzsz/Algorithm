package com.bsb.leetcode;

import java.util.Stack;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-17 22:37
 */
public class T9 {
    public boolean isPalindrome(int x) {

        String str = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
