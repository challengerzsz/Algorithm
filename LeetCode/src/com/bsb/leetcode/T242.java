package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 20:11
 */
public class T242 {

    // 有效的字母异位词
    // 判断t是否是s的异位词
    // easy题目 其实也就是说s能否通过改变排列的方式去匹配t
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];
        for (char temp : s.toCharArray()) {
            map[temp - 'a']++;
        }
        for (char temp : t.toCharArray()) {
            if (map[temp - 'a']-- == 0) return false;
        }
        return true;
    }
}
