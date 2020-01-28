package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 14:31
 */
public class T131 {

    public List<List<String>> partition(String s) {
        return helper(s, 0);
    }

    // 分治  因为这个题目是划分s串为多个可能的回文串 其中一种结果就是s串里的单个字符
    // 所以理所应当想到分治到每一个字符为止的递归解法
    private List<List<String>> helper(String s, int start) {

        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            // 判断分治到某一个串的时候是不是回文串
            if (check(s.substring(start, i + 1))) {
                String left = s.substring(start, i + 1);
                // 添加到结果集
                for (List<String> list : helper(s, i + 1)) {
                    list.add(0, left);
                    ans.add(list);
                }
            }

        }
        return ans;
    }

    private boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        new T131().partition("aab");
    }
}
