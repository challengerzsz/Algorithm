package com.bsb.leetcode;

import java.util.Stack;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-07 23:47
 */
public class T5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] max = {0, 0 ,0};
        int length;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (checkIfCircleStr(s, i, j)) {
                    length = j - i + 1;
                    if (length > max[0]) {
                        max[0] = length;
                        max[1] = i;
                        max[2] = j;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = max[1]; i <= max[2]; i++) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

    private boolean checkIfCircleStr(String str, int start, int end) {

        Stack<Character> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            stack.push(str.charAt(i));
        }

        for (int i = start; i <= end; i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T5().longestPalindrome("121"));
    }
}
