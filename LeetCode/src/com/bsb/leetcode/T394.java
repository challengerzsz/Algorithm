package com.bsb.leetcode;

import java.util.LinkedList;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-11 21:04
 */
public class T394 {


    // 双栈解决字符串decoding
    // 遍历字符串
    // 1、字符为数字，解析数字存入 num
    // 2、字符为字母，拼接字母 存入 str
    // 3、字符为左括号，把之前得到的数字 num 和 字母 str 分别压栈 然后把数字重置为0，字母字符串重置为空串
    // 4、字符为右括号，数字栈栈顶数字出栈 作为重复次数 n 字母栈栈顶字母出栈作为前缀字母字符串去拼接 str 字母变量
    // 总共拼接 n 次 拼接后的新字母串给 str
    public String decodeString(String s) {
        // 重复的次数栈
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';

            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);

            } else if (c == '[') {
                if (num > 0) numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                num = 0;

            } else {
                // ']'的情况
                StringBuilder preSb = new StringBuilder().append(strStack.pop());
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    preSb.append(sb);
                }
                sb = preSb;
            }
        }
        return sb.toString();
    }

}
