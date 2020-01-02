package com.bsb.leetcode;

import com.bsb.didi.T3;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 15:13
 */
public class T38 {

    // 这题其实就是报数
    // 递归解

    public String countAndSay(int n) {
        if (n == 1) return "1";
        int count = 1;
        String res = "";
        String str = countAndSay(n - 1);
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                res += count + "" + str.charAt(i);
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T38().countAndSay(4);
    }
}
