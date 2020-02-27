package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 15:10
 */
public class T784 {

    // 字母大小全排列
    // S中可能会有数字 对数字不作处理 对每一个字母都可以以大小写形式来组合
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        dfs(S, 0, "", res);
        return res;
    }

    private void dfs(String s, int index, String temp, List<String> res) {
        if (index == s.length()) {
            res.add(temp);
            return;
        }

        if (s.charAt(index) >= '0' && s.charAt(index) <= '9') dfs(s, index + 1, temp + s.charAt(index), res);
        else {
            dfs(s, index + 1, temp + s.charAt(index), res);
            if (Character.isLowerCase(s.charAt(index))) {
                dfs(s, index + 1, temp + Character.toUpperCase(s.charAt(index)), res);
            } else {
                dfs(s, index + 1, temp + Character.toLowerCase(s.charAt(index)), res);
            }

        }
    }

    // 位掩码
    // a1b => 00 A1b => 10 A1B => 11 a1B = 01
    public List<String> letterCasePermutation2(String S) {
        int count = 0;
        // 统计字符个数
        for (char c : S.toCharArray())
            if (Character.isLetter(c)) count++;

        List<String> ans = new ArrayList<>();

        // 1 << count其实是总共有多少种排列
        for (int bits = 0; bits < (1 << count); bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter : S.toCharArray()) {
                // 是字母和不是字母需要区别处理
                if (Character.isLetter(letter)) {
                    if (((bits >> b++) & 1) == 1)
                        word.append(Character.toLowerCase(letter));
                    else
                        word.append(Character.toUpperCase(letter));
                } else {
                    word.append(letter);
                }
            }

            ans.add(word.toString());
        }

        return ans;

    }

    public static void main(String[] args) {
        new T784().letterCasePermutation("a2345");
    }
}
