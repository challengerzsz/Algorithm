package com.bsb.leetcode.vip.bytedance;

import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 17:55
 */
public class T20 {

    // 有效括号
    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.trim().length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() > s.length() / 2) return false;
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
