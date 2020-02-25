package com.bsb.leetcode.tag.bytedane.string;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 18:35
 */
public class T5 {

    // 翻转字符串单词
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) return "";
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if ("".equals(strs[i])) continue;
            res.append(strs[i]).append(" ");
        }
        return res.toString().substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
//        System.out.println("  a b c".split(" ").length);
//        System.out.println("abc".substring(0, 2));
        System.out.println(new T5().reverseWords("  hello world!  "));
    }
}
