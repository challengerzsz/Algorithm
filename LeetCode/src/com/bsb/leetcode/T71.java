package com.bsb.leetcode;

import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-04 17:13
 */
public class T71 {

    // 简化路径
    // 利用栈 我看题解有人用了golang的库函数对path做了操作 看傻了
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (s.equals("") || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/");
            sb.append(stack.get(i));
        }
        String res = sb.toString();
        return res.length() == 0 ? "/" : res;
    }

    public static void main(String[] args) {
        new T71().simplifyPath("/a/../../b/../c//.//");
    }
}
