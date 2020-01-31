package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-31 16:15
 */
public class T316 {

    // (要求不能打乱其他字符的相对位置)
    public String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for (Character temp : s.toCharArray()) {
            if (set.contains(temp)) continue;
            set.add(temp);
            list.add(temp);
        }
        list.sort((o1, o2) -> o1 > o2 ? 1 : o1 == o2 ? 0 : -1);
        for (Character temp : list) {
            sb.append(temp);
        }

        return sb.toString();
    }

    // 栈解决 利用栈的特点和题目需要的字典序
    public String removeDuplicateLetters2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c)) continue;
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            stack.push(c);
        }
        char[] res = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++)
            res[i] = stack.get(i);

        return new String(res);
    }
}
