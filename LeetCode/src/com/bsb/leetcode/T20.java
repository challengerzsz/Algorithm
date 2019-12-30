package com.bsb.leetcode;

import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-30 14:28
 */
public class T20 {

    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.trim().length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                continue;
            }
            if (!stack.isEmpty()) {
                char t = stack.peek();
                if (t == '(' && s.charAt(i) == ')') {
                    stack.pop();
                    continue;
                }
                if (t == '{' && s.charAt(i) == '}') {
                    stack.pop();
                    continue;
                }
                if (t == '[' && s.charAt(i) == ']') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new T20().isValid("()[]{}");
    }
}
